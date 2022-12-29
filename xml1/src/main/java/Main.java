import java.util.*;

public class Main {
    private static final Map<String, Person> person_id_map = new HashMap<>();
    private static final Map<String, Set<String>> name_id_map = new HashMap<>();
    private static final Map<String, Set<Person>> name_person_noId_map = new HashMap<>();


    public static void main(String[] args) {
        XmlParser xmlParser = new XmlParser();
        List<Person> persons = xmlParser.parseXMLfile("people.xml");
        persons = relationsSet(persons);

        List<Person> incorrectPeople = persons.stream().filter(p ->
                p.isIncorrect(person_id_map)).toList();

        for (Person problemPerson : incorrectPeople) {
            Set<Person> personsNoId = new HashSet<>();
            for (final Set<Person> personSet : name_person_noId_map.values()) {
                for (Person personNoId : personSet)
                    if (personNoId.getFullName().equals(problemPerson.getFullName()))
                        personsNoId.add(personNoId);
            }
            restoreGndr(problemPerson,personsNoId);
            restoreSpouse(problemPerson,personsNoId);
            restoreChilds(problemPerson, personsNoId);

        }

        for (final Person person : person_id_map.values())
            if (person.getSpouse() == null || person.getChildCnt() == null)
                person.setChildCnt(0);


//        incorrectPeople = persons.stream().filter(p ->
//                p.isIncorrect(person_id_map)).toList();
//        System.out.println(incorrectPeople.size());
        for(int i=0;i<20;i++){
            System.out.println(persons.get(i));
        }
    }

    private static List<Person> relationsSet(List<Person> people) {
        for (final Person person : people) {
            final String id = person.getId();
            //storing info with no id persons by their names
            if (id == null) {
                Set<Person> noId = name_person_noId_map.getOrDefault(person.getFullName(), new HashSet<>());
                noId.add(person);
                name_person_noId_map.put(person.getFullName(), noId);
                continue;
            }
            // merging one Id's
            if (person_id_map.containsKey(id)) {
                Person collision = person_id_map.get(id);
                person.merge(collision);
            }
            person_id_map.put(id, person);
        }

        for (final Person person : person_id_map.values()) {
            final String name = person.getFullName();
            if (person.getId() == null || name == null)
                throw new RuntimeException("No name and Id:"+ person.getFullName());

            Set<String> ids = name_id_map.getOrDefault(name, new HashSet<>());
            ids.add(person.getId());
            name_id_map.put(name, ids);
        }

        // merging person_id_map with persons
        for (final Person person : people) {
            final String name = person.getFullName();
            if (name == null) continue;

            final Set<String> ids = name_id_map.get(name);
            final String id = ids.size() == 1 ?
                    ids.iterator().next() : null;

            if (id != null) {
                person.setId(id);
                person_id_map.get(id).merge(person);
            }
        }

        // adding all spouses etc
        for (final Person person : person_id_map.values()) {
            if (person.getSpouse() != null) {
                final Set<Person> sposeAdd = new HashSet<>();
                inverseRel(sposeAdd, person.getSpouse());

                if (!sposeAdd.isEmpty()) {
                    final Person spouse = sposeAdd.iterator().next();
                    person.setSpouse(spouse);
                }
            }

            Set<Person> childAdd = new HashSet<>();
            for (final Person child : person.getChilds()) {
                inverseRel(childAdd, child);
            }
            person.getChilds().clear();
            childAdd.forEach(person::addChild);

            Set<Person> sibAdd = new HashSet<>();
            for (final Person sibling : person.getSibs())
                inverseRel(sibAdd, sibling);
            person.getSibs().clear();
            sibAdd.forEach(person::addSibling);

            Set<Person> parAdd = new HashSet<>();
            for (final Person parent : person.getParents())
                inverseRel(parAdd, parent);
            person.getParents().clear();
            parAdd.forEach(person::addParent);
        }


        return person_id_map.values().stream().sorted(Comparator.comparing(Person::getId)).toList();
    }

    private static void inverseRel(final Set<Person> peopleToAdd, final Person person) {
        if (person.getId() != null) {
            final String id = person.getId();
            peopleToAdd.add(person_id_map.get(id));
        } else if (person.getFullName() != null) {
            final String name = person.getFullName();
            final Set<String> ids = name_id_map.get(name);

            if (ids.size() == 1) {
                final String id = ids.iterator().next();
                peopleToAdd.add(person_id_map.get(id));
            }
        }
    }

    private static void restoreGndr(Person person, Set<Person> noId){
        // restore gndr by spouse
        if (person.getGndr() == null)
            for (Person pers : noId)
                if (pers.getSpouse() != null && Objects.equals(person.getId(), pers.getSpouse().getId()))
                    person.setGndr(pers.getSpouse().getGndr());
        //restore gndr by sibling
        if (person.getGndr() == null)
            for (Person pers : noId)
                for (Person otherSibling : pers.getSibs())
                    for (Person personSibling : person.getSibs())
                        if (personSibling.getId().equals(otherSibling.getId()))
                            if (pers.getGndr() != null)
                                person.setGndr(pers.getGndr());
    }
    private static void  restoreSpouse(Person person, Set<Person> noId){
        //restoring spouses
        if (person.getSpouse() == null)
            for (Person pers : noId) {
                if (pers.getSpouse() != null && Objects.equals(person.getId(), pers.getSpouse().getId())) {
                    person.setSpouse(pers);
                    if (person.getSpouse().getId() == null) {
                        for (Person innerOther : noId) {
                            if (person.getSpouse() != null &&
                                    person.getSpouse().getFullName().equals(innerOther.getFullName()) &&
                                    innerOther.getSpouse() != null &&
                                    innerOther.getSpouse().getId() != null &&
                                    !Objects.equals(innerOther.getSpouse().getId(), person.getId())) {
                                person.setSpouse(person_id_map.get(innerOther.getSpouse().getId()));
                            }
                        }
                    }
                    break;
                }
            }
        //finding a wife with an id
        if (person.getSpouse() != null && person.getSpouse().getId() == null) {
            Set<String> spouces = name_id_map.get(person.getSpouse().getFullName());
            for (String spouce : spouces) {
                for (Person possibleChild : person_id_map.get(spouce).getChilds()) {
                    if (person.getChilds().contains(possibleChild)) {
                        person.deleteSpouce();
                        person.setSpouse(person_id_map.get(spouce));
                        break;
                    }
                }
                if (person.getSpouse().getId() != null) {
                    break;
                }
            }
        }

        if (person.getSpouse() != null && person.getSpouse().getGndr() == null) {
            person.getSpouse().setGndr(person.getGndr().equals("male")?"female":"male");
        }

        //restore wife id by siblings
        if (person.getSpouse() != null && person.getSpouse().getId() == null) {
            if (person.getSpouse().getSiblCnt() != null && person.getSpouse().getSiblCnt() == 1) {
                Set<String> spouceSiblings = name_id_map.get(person.getSpouse().getFullName());
                if (spouceSiblings.size() == 2) {
                    for (String sibling : spouceSiblings) {
                        if (Objects.equals(person.getId(), sibling))
                            continue;
                        if (person_id_map.get(sibling).getId() != null) {
                            person.setSpouse(person_id_map.get(sibling));
                            person.getSpouse().setSpouse(person_id_map.get(person.getId()));
                        }
                    }
                }
            }
        }
    }
    private static void restoreChilds(Person person, Set<Person> noId) {
        //finding forgotten childs from the wife
        if (person.getChildCnt() == null || person.getChildCnt() > person.getChilds().size()) {
            if (person.getSpouse() != null) {
                for (Person forgottenChild : person.getSpouse().getChilds()) {
                    person.getChilds().add(forgottenChild);
                    forgottenChild.addParent(person);
                }
            }
        }
    }
}
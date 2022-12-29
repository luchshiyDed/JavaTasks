import java.util.*;
import java.util.stream.Stream;

public class Person {
    private String id;
    private String Name;
    private String lstName;
    private String gndr;
    private Person spouse;

    private final Set<Person> parents = new HashSet<>();
    private final Set<Person> sibs = new HashSet<>();
    private final Set<Person> childs = new HashSet<>();

    private Integer childCnt;
    private Integer siblCnt;

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, lstName, gndr, childCnt, siblCnt);
    }

    @Override
    public String toString() {
        return "id: " + id + " Name: " + Name + " lstName: " + lstName + " gndr: " + gndr + " childrenCnt: " + childCnt + " siblingsCnt: " + siblCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (this.id != null && person.id != null && this.id.equals(person.id))
            return true;

        return this.getFullName() != null && person.getFullName() != null && this.getFullName().equals(person.getFullName());
    }

    public Person() {
    }

    public Person(String id) {

        this.id = id;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }


    public void setName(String name) {
        if (this.Name != null && !this.Name.equals(name)) {
            System.out.println("Trying to replace not-null name: " + this.Name + " on: " + name);
            return;
        }
        this.Name = name;
    }


    public void setLstName(String lstName) {
        if (this.lstName != null && !this.lstName.equals(lstName)) {
            System.out.println("Trying to replace not-null last name: " + this.lstName + " on: " + lstName);
            return;
        }
        this.lstName = lstName;
    }

    public String getFullName() {
        if (Name != null && lstName != null) {
            return Name + " " + lstName;
        }
        return null;
    }

    public void setFullName(String fullName) {
        String[] words = fullName.split(" +");
        setName(words[0]);
        setLstName(words[1]);
    }

    public String getGndr() {
        return gndr;
    }

    public void setGndr(String gndr) {
        if (this.gndr != null && !this.gndr.equals(gndr)) {
            System.out.println("Trying to replace gender");
        }
        this.gndr = gndr;
    }

    public Integer getChildCnt() {
        return childCnt;
    }

    public void setChildCnt(int childCnt) {
        this.childCnt = childCnt;
    }

    public Integer getSiblCnt() {
        return siblCnt;
    }

    public void setSiblCnt(int siblCnt) {
        this.siblCnt = siblCnt;
    }

    public Set<Person> getSibs() {

        return sibs;
    }

    public void addSibling(Person sibling) {
        if (sibling.siblCnt == null) sibling.siblCnt = siblCnt;
        if (siblCnt == null) siblCnt = sibling.siblCnt;

        sibs.add(sibling);
        sibling.sibs.add(this);
    }

    public void addSibling(String id) {

        addSibling(new Person(id));
    }

    public void addSibling(String name, String gender) {
        Person sibling = new Person();
        sibling.setFullName(name);
        sibling.setGndr(gender);
        addSibling(sibling);
    }

    public Set<Person> getChilds() {

        return childs;
    }

    public void addChild(Person child) {
        childs.add(child);
        child.parents.add(this);
    }

    public void addChild(String name) {
        Person child = new Person();
        child.setFullName(name);
        addChild(child);
    }

    public void addChild(String id, String gender) {
        Person child = new Person(id);
        child.setGndr(gender);
        addChild(child);
    }

    public Set<Person> getParents() {

        return parents;
    }

    public void addParent(Person parent) {
        parent.childs.add(this);
        parents.add(parent);
    }

    public void addParent(String id) {
        Person parent = new Person(id);
        addParent(parent);
    }

    public void addParent(String fullname, String gender) {
        Person parent = new Person();
        parent.setFullName(fullname);
        parent.setGndr(gender);
        addParent(parent);
    }

    public Person getSpouse() {

        return spouse;
    }

    public void setSpouse(Person spouce) {
        this.spouse = spouce;
        spouce.spouse = this;
        if (spouse.childCnt != null)
            this.setChildCnt(spouse.childCnt);
        else if (this.childCnt != null)
            spouce.setChildCnt(this.childCnt);
    }

    public void deleteSpouce() {

        this.spouse = null;
    }

    public void setSpouse(String name) {
        Person spouce = new Person();
        spouce.setFullName(name);
        setSpouse(spouce);
    }

    public void setWife(String id) {
        Person wife = new Person(id);
        wife.setGndr("female");
        setSpouse(wife);
        setGndr("male");
    }

    public void setHusband(String id) {
        Person husband = new Person(id);
        husband.setGndr("male");
        setSpouse(husband);
        setGndr("female");
    }

    public boolean isIncorrect(final Map<String, Person> personById) {
        return id == null || Name == null || lstName == null || gndr == null ||
                parents.size() > 2 || childCnt == null || siblCnt == null ||
                childs.size() != childCnt || sibs.size() != siblCnt ||

                (spouse == null && childCnt != 0) ||

                !childs.stream()
                        .map(Person::getParents)
                        .allMatch(s -> Arrays.asList(s.toArray()).contains(this)) ||

                !parents.stream()
                        .map(Person::getChilds)
                        .allMatch(s -> Arrays.asList(s.toArray()).contains(this)) ||

                !sibs.stream()
                        .map(Person::getSibs)
                        .allMatch(s -> Arrays.asList(s.toArray()).contains(this)) ||

                !Stream.concat(
                        Stream.of(childs, sibs, parents)
                                .flatMap(Collection::stream),
                        Stream.ofNullable(spouse)
                ).allMatch(p -> p.id != null && personById.get(p.id) == p);
    }

    public void merge(Person person) {
        if (person == this) return;

        if (person.Name != null)
            this.setName(person.Name);

        if (person.lstName != null)
            this.setLstName(person.lstName);

        if (person.gndr != null)
            this.setGndr(person.gndr);


        if (person.childCnt != null)
            this.setChildCnt(person.childCnt);


        if (person.siblCnt != null)
            this.setSiblCnt(person.siblCnt);

        for (Person sibling : person.sibs) {
            sibling.sibs.remove(person);
            sibling.sibs.add(this);
            this.sibs.add(sibling);
        }

        if (person.spouse != null) {
            this.spouse = person.spouse;
            this.spouse.spouse = this;
        }

        for (Person parent : person.parents) {
            parent.childs.remove(person);
            parent.childs.add(this);
        }

        for (Person child : person.childs) {
            child.parents.remove(person);
            child.parents.add(this);
            this.childs.add(child);
        }


    }


}
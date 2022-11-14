(defn remover [s a]
  (remove #(=(str(last s)) %) a))

(defn strXalph [s a]
  (map str (repeat (count a) s) a))

(defn sXa [s a]
  (strXalph s (remover s a)))

(defn strXstr [s1 s2]
  (apply concat (map #(sXa % s2) s1)))

(defn enter [a n]
  (reduce strXstr (repeat n a)))

(println (enter (list "a" "b" "c") 7))
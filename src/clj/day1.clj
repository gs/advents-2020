;; https://adventofcode.com/2020/day/1
(ns clj.day1)

(defn read-file []
  (slurp "resources/day1-input.txt"))

(defn find-matching-numbers-1 []
  (def numbers (clojure.string/split-lines (read-file)))
  (for [x numbers
        y numbers
        :when (= (+ (Integer/parseInt x) (Integer/parseInt y)) 2020)]
    (flatten [(Integer/parseInt x) (Integer/parseInt y)])))




(defn find-matching-numbers-2 []
  (def numbers (clojure.string/split-lines (read-file)))
  (for [x numbers
        y numbers
        z numbers
        :when (= (+ (Integer/parseInt x)
                    (Integer/parseInt y)
                    (Integer/parseInt z)) 2020)]
    (flatten [(Integer/parseInt x) (Integer/parseInt y) (Integer/parseInt z)])))


(defn calculate-1 []
  (reduce * (distinct (flatten (distinct (find-matching-numbers-1))))))

(defn calculate-2 []
  (reduce * (distinct (flatten (distinct (find-matching-numbers-2))))))

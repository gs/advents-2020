;; https://adventofcode.com/2020/day/1
(ns clj.day1)

(def read-file 
  (map #(Integer/parseInt %)
       (clojure.string/split-lines
        (slurp "resources/day1-input.txt"))))


(defn find-matching-numbers-1 []
  (first (for [x read-file
               y read-file
               :when (= (+ x y) 2020)]
           (* x y))))

(find-matching-numbers-1)

(defn find-matching-numbers-2 []
  (first (for [x read-file
               y read-file
               z read-file
               :when (= (+ x y z) 2020)]
           (* x y z ))))


(find-matching-numbers-2)

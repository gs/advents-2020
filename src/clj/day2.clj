(ns day2
  (:require
   [clojure.string :refer [split split-lines]]))


(defn read-file []
  (split-lines (slurp "resources/day2-input.txt")))
;; => #'day2/read-file


(def inputs ["1-3 c: abcd" "1-2 a: cddba" "1-2 x: abcd"])
;; => #'day2/inputs

(defn split-string "" [string]
  (let [array (split string #" ")]
    (let [occurences (vec (map #(Integer/parseInt %) (split (first array) #"-")))]
    [occurences (first(split(second array) #":")) (last array)])))

;(map #(Integer/parseInt %)(first (split-string "1-3 c: abcd")))

(split-string "1-2 x: abcd")
;; => [[1 2] "x" "abcd"]


(defn count_letters_in_password
  ""
  [letter, password]
  (def letter-regexp (re-pattern letter))
  (count (re-seq letter-regexp  password))
  )

(count_letters_in_password "x" "abcd")
;; => 0

(defn genarate_range [list]
  (vec (range (first list)(+ (last list) 1))))
;; => #'day2/genarate_range

(defn letters_in_occuences
  ""
  [count occurences]
  (some #(= count %) (genarate_range occurences))
  )
;; => #'day2/letters_in_occuences

(defn main []
  (for [input (read-file)]
    (let [line (split-string input)]
      (let [result (count_letters_in_password (second line) (last line))]
        (letters_in_occuences result (first line))))))

(time(frequencies (main)))



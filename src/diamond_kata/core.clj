(ns diamond-kata.core
  (:require [clojure.string :as string]))

(defn letter-index [letter]
  (- (int (first letter)) 65))

(defn in-between [letter]
  (let [index (letter-index letter)
        dashes-between (repeat (- (* 2 index) 1) "-")]
    (if (= 0 index) letter
      (str letter (string/join "" dashes-between) letter))))

(defn outside [letter diamond-letter]
  (let [first-index (letter-index letter)
        last-index (letter-index diamond-letter)
        dashes (- last-index first-index)]
    (string/join "" (repeat dashes "-"))))

(defn whole-line [letter diamond-letter]
  (let [inner (in-between letter)
        outer (outside letter diamond-letter)]
    (str outer inner outer)))

(defn letters-list [letter]
  (let [letter-value (int (first letter))]
  (map #(str (char %)) (concat
                         (range (int \A) (inc letter-value))
                         (range (- letter-value 1) (- (int \A) 1) -1)))))

(defn diamond [letter]
  (let [letters (letters-list letter)]
    (print (string/join "\n" (map #(whole-line % letter) letters)))))

(ns diamond-kata.core-spec
  (:require [speclj.core :refer :all]
            [diamond-kata.core :refer :all]))

(describe "Diamond created for"
  (it "A"
    (should= "A" (with-out-str (diamond "A"))))
  (it "B"
    (should= "-A-\nB-B\n-A-" (with-out-str (diamond "B"))))
  (it "C"
    (should= "--A--\n-B-B-\nC---C\n-B-B-\n--A--" (with-out-str (diamond "C")))))

(describe "Returns index of the letter"
  (it "A"
    (should= 0 (letter-index "A")))
  (it "B"
    (should= 1 (letter-index "B")))
  (it "C"
    (should= 2 (letter-index "C")))
  (it "K"
    (should= 10 (letter-index "K"))))

(describe "Builds the line between the occurances of the letter"
  (it "A"
    (should= "A" (in-between "A")))
  (it "B"
    (should= "B-B" (in-between "B")))
  (it "C"
    (should= "C---C" (in-between "C")))
  (it "K"
    (should= "K-------------------K" (in-between "K"))))

(describe "Builds the outside part for a letter inside the letter-diamond"
  (it "A in A"
    (should= "" (outside "A" "A")))
  (it "A in B"
    (should= "-" (outside "A" "B")))
  (it "B in C"
    (should= "-" (outside "B" "C")))
  (it "A in C"
    (should= "--" (outside "A" "C")))
  (it "A in K"
    (should= "----------" (outside "A" "K")))
  (it "C in K"
    (should= "--------" (outside "C" "K"))))

(describe "Puts together the outside and in-between function to create a line"
  (it "A in A"
    (should= "A" (whole-line "A" "A")))
  (it "A in B"
    (should= "-A-" (whole-line "A" "B")))
  (it "B in C"
    (should= "-B-B-" (whole-line "B" "C")))
  (it "A in C"
    (should= "--A--" (whole-line "A" "C")))
  (it "A in K"
    (should= "----------A----------" (whole-line "A" "K")))
  (it "C in K"
    (should= "--------C---C--------" (whole-line "C" "K"))))

(describe "Creates a list of letters starting from A going to"
  (it "A"
    (should= '("A") (letters-list "A")))
  (it "B"
    (should= '("A" "B" "A") (letters-list "B")))
  (it "C"
    (should= '("A" "B" "C" "B" "A") (letters-list "C"))))



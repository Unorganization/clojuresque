(ns clojuresque.conditions)

(defn can-vote [age]
  (if (>= age 18)
    (println "You can vote")
    (println "You can't vote")))

(defn can-do-more [age]
  (if (>= age 18)
    (do (println "You can drive")
        (println "You can vote"))
    (println "You can't vote")))

    ; when like if without else
(defn when-ex [tof]
  (when tof
    (println "1st thing")
    (println "2nd thing")))

(defn what-grade [n]
  (cond
    (< n 5) (println "Preschool")
    (= n 5) (println "Kindergarten")
    (and (> n 5) (<= n 18)) (println (format "Go to grade %d" (- n 5)))
    :else (println "Go to college")))

; case
(defn case-ex1 [input-num]
  (case input-num
    1 "one"
    2 "two"
    3 "three"
    "don't know"))

; fac without recur
(defn calc-factorial [num]
  (if (zero? num)
    1
    (* num (calc-factorial (dec num)))))
,,, (calc-factorial 5)  ; 120

; fac using recur
(def calc-factorial2
  (fn [n]
    (loop [cnt n
           acc 1]
      (if (zero? cnt)
        acc
        (recur (dec cnt) (* acc cnt))
; in loop cnt will take the value (dec cnt)
; and acc will take the value (* acc cnt)
        ))))

(defn conditions []
  ,,, (println "conditions:")
  ,,, (println (not false))  ; true
  ,,, (println (= 5 6))  ; false
  ,,, (println (not= 5 6))  ; true
  ,,, (println (<= 5 6))  ; true
  ,,, (println (and true false))  ; false
  ,,, (println (or true false))  ; true

  ,,, (println (if (= 5 3) 1 0))  ; 0
  ,,, (println (if-not (= 5 3) 1 0))  ; 1
  ,,, (println (when (= 5 5) 1))  ; 1
  ,,, (println (when-not (= 5 5) 1))  ; nil
  ,,, (println (when (not= 5 5) 1))  ; nil

  ,,, (println "can-vote 17")  (can-vote 17)  ; You can't vote
  ,,, (println "can-vote 18")  (can-vote 18)  ; You can vote
  ,,, (println "can-vote 19")  (can-vote 19)  ; You can vote

  ,,, (println "can-do-more 17")  (can-do-more 17)  ; You can drive
  ,,, (println "can-do-more 18")  (can-do-more 18)  ; You can vote
  ,,, (println "can-do-more 19")  (can-do-more 19)  ; You can vote

  (when-ex true)  ; 1st thing  \n  2nd thing
  (when-ex false)  ; (no output)

  (what-grade 4)  ; Preschool
  (what-grade 5)  ; Kindergarten
  (what-grade 10)  ; Go to grade 5
  (what-grade 17)  ; Go to grade 12
  (what-grade 19)  ; Go to college

  (println (case-ex1 1))  ; one
  (println (case-ex1 2))  ; two
  (println (case-ex1 3))  ; three
  (println (case-ex1 4))  ; don't know
  
  ,,, (calc-factorial2 5)  ; 120

; recur
  (loop [i 0]
    (when (< i 5)
      (println i)
      (recur (inc i)); loop i will take this value
      ))  ; 0\n 1\n 2\n 3\n 4\n
  )


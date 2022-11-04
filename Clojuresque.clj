(ns Clojuresque
  (:require [clojure.string :as str]) ; can use short name 'str'
  (:gen-class))

(println "Hello World!")

,,,(println "numbers:")
(def myint 10) ,,,(println myint)
(def mydbl 3.14) ,,,(println mydbl)
,,,(println (type mydbl))  ; show type
,,,(println (nil? mydbl))  ; test for nil
,,,(println (pos? -1) (neg? -1)  ; test for positive or negative value
            (even? -1) (odd? -1)  ; test for even or odd
            (number? -1) (integer? -1)  ; is number?  is float 
            (zero? -1)  ; is zero
            )

,,,(println "strings:")
(def str1 "Hello")
,,, (println (format "This is a string %s" str1))
,,, (println (str/blank? str1))
,,, (println (str/includes? str1 "Hell"))
,,, (println (str/index-of str1 "llo"))
,,, (println (str/split str1 #" "))
,,, (println (str/split str1 #"l"))
,,, (println (str/join " " ["The" "Big" "Cheese"]))
,,, (println (str/replace "I am 42" #"42", "43"))  ; "I am 43"
,,, (println (str/trim "  hi  "))
,,, (println (str/trim-newline "  hi  "))
,,, (println (str/trimr "  hi  "))
,,, (println (str/triml "  hi  "))
,,, (println (str/upper-case "  hi  "))
,,, (println (str/lower-case "  HI  "))

,,,(println "lists:")
,,, (println '(1 2 3 "Dog", true, 4.2))
(def list1 (list 4 5 6))
,,, (println (first list1))  ; 4
,,, (println (rest list1))  ; (5 6)
,,, (println (nth list1 1))  ; 5
,,, (println (conj list1 3))  ; (3 4 5 6)
,,, (println (conj list1 3 2 1))  ; (1 2 3 4 5 6)
,,, (println (list* 3 list1))  ; (3 4 5 6)
,,, (println (list* 1 2 3 list1)) ; (1 2 3 4 5 6)
,,, (println (cons 3 list1))  ; (3 4 5 6)

,,,(println "sets:")
,,, (println #{ 1 2 3 })  ; #{ 1 3 2 }
,,, (println (set (list 1 1 2)))  ; #{1 2}
(def set1 (set '(4 5 6)))
,,, (println (get set1 6))  ; 6
,,, (println (get set1 66))  ; nil
,,, (println (contains? set1 6))  ; true
,,, (println (conj set1 7))  ; #{ 7 4 6 5 }
,,, (println (disj set1 4))  ; #{ 6 5 }

,,,(println "vectors:")
,,, (println (vector 1 2 3))  ; [1 2 3 ]
(def vec1 [1 2 3 "Cat"])
,,, (println vec1)  ; [1 2 3 Cat]
,,, (println (get vec1 3))  ; Cat
,,, (println (conj vec1 3))  ; [ 1 2 3 Cat 3 ]
,,, (println (pop vec1))  ; [1 2 3]
,,, (println (subvec [99 88 77 66 55] 2 4 ))  ; [77 66]

,,,(println "maps:")
,,, (println (hash-map "y" 3 "x" 4))   ; {x 4, y 3}
,,, (println (sorted-map "y" 3 "x" 4))  ; {x 4, y 3}
(def map1 {"b" 6 "a" 5})
,,, (println map1)  ; {a 6, b 5}
,,, (println (get map1 "b"))  ; 6
,,, (println (find map1 "b"))  ; [b 6]
,,, (println (contains? map1 "b"))  ; true
,,, (println (keys map1))  ; (b, a)
,,, (println (vals map1))  ; (6 5)
,,, (println (merge map1 (hash-map "y" 3 "x" 4)))  ; {b 6, a 5, x 4, y 3}
,,, (println (merge-with + map1 (hash-map "y" 3 "x" 4)))  ; {b 6, a 5, x 4, y 3}

,,,(println "atoms:")
(defn atom-ex [x]
  (def atomEx (atom x))
  (add-watch atomEx :watcher
       (fn [key atom old-state new-state]
         (println "atomEx changed from "
                  old-state " to " new-state)))
  (println "1st x" @atomEx)
  (reset! atomEx 10)
  (println "2nd x" @atomEx)
  (swap! atomEx inc)
  (println "Increment x" @atomEx)
  )
(atom-ex 5)

,,, (println "agents:")
(defn agent-ex []
  (def tickets-sold (agent 0))

  (send tickets-sold + 15)
  (await-for 100 tickets-sold)
  (println "Tickets: " @tickets-sold)

  (send tickets-sold + 10)
  (await-for 100 tickets-sold)
  (println "Tickets: " @tickets-sold)

  (shutdown-agents)
  )
(agent-ex)

,,, (println "math stuff:")
,,, (println (+ 1 2 3))  ; 6
,,, (println (- 5 3 2))  ; 0
,,, (println (* 2 5))  ; 10
,,, (println (/ 10 5))  ; 2
,,, (println (mod 12 5))  ; 2

,,, (println (inc 5))  ; 6
,,, (println (dec 5))  ; 4

,,, (println 
     (Math/abs -10)  ; 10
     (Math/cbrt -8)  ; -2.0
     (Math/sqrt 4)  ; 2.0
     (Math/ceil 4.5)  ; 5.0
     (Math/floor 4.5)  ; 4.0
     (Math/exp 1)  ; 2.718281828459045
     (Math/hypot 2 2)   ; 2.828427124
     (Math/log 2.71828)  ; 1
     (Math/log10 100)  ; 2.0
     (Math/max 1 5)  ; 5
     (Math/min 1 5)  ; 1
     (Math/pow 2 2)  ; 4.0
  )
,,, (println (rand-int 20))  ; random 0-19

,,, (println (reduce + [1 2 3]))  ; 6
,,, (println Math/PI)

,,, (println "functions:")
(defn say-hello
  "Receives a name with 1 parameter and responds"
  [name]
  
  (println "Hello again" name)
  )
(say-hello "bob")

(defn get-sum [x y]
  (+ x y))
,,, (println (get-sum 5 6))  ; 11

(defn get-sum-more
  ([x y z]
  (+ x y z))

  ([x y]
   (+ x y))
)
,,, (println (get-sum-more 6 7))  ; 13
,,, (println (get-sum-more 5 6 7))  ; 18

(defn hello-you [name]
  (str "Hello " name)
  )

(defn hello-all [& names]
  (map hello-you names)
  )

,,,(println (hello-all "kenny" "michelle" "aaron"))
    ; (Hello kenny Hello michelle Hello aaron)

,,, (println "condition:")
,,, (println (not false))  ; true
,,, (println (= 5 6))  ; false
,,, (println (not= 5 6))  ; true
,,, (println (<= 5 6))  ; true
,,, (println (and true false))  ; false
,,, (println (or true false))  ; true

(defn can-vote [age]
  (if (>= age 18)
    (println "You can vote")
    (println "You can't vote")
    )
  )

,,, (println "can-vote 17")  (can-vote 17)  ; You can't vote
,,, (println "can-vote 18")  (can-vote 18)  ; You can vote
,,, (println "can-vote 19")  (can-vote 19)  ; You can vote

(defn can-do-more [age]
  (if (>= age 18)
    (do (println "You can drive")
      (println "You can vote"))
    (println "You can't vote"))
  )
,,, (println "can-do-more 17")  (can-do-more 17)  ; You can drive
,,, (println "can-do-more 18")  (can-do-more 18)  ; You can vote
,,, (println "can-do-more 19")  (can-do-more 19)  ; You can vote

(defn when-ex [tof]
  (when tof 
    (println "1st thing")
    (println "2nd thing")))
(when-ex true)  ; 1st thing  \n  2nd thing
(when-ex false)  ; (no output)

(defn what-grade [n]
  (cond
    (< n 5) (println "Preschool")
    (= n 5) (println "Kindergarten")
    (and (> n 5) (<= n 18)) (println (format "Go to grade %d" (- n 5)))
    :else (println "Go to college")))
(what-grade 4)  ; Preschool
(what-grade 5)  ; Kindergarten
(what-grade 10)  ; Go to grade 5
(what-grade 17)  ; Go to grade 12
(what-grade 19)  ; Go to college

,,, (println "looping:")
(defn one-to-x [x]
  (def i (atom 1))
  (while (<= @i x)
    (do
      (println @i)
      (swap! i inc))))
,,, (println "one-to-x 5")  (one-to-x 5)  ; 1 \n 2 \n 3 \n 4 \n 5 \n

(defn dbl-to-x [x]
  (dotimes [i x]
    (println (* i 2))))
,,, (println "dbl-to-x 5")  (dbl-to-x 5)  ; 0 \n 2 \n 4 \n 6 \n 8 \n

(defn triple-to-x [x, y]
  (loop [i, x]
    (when (< i y)
      (println (* i 3))
      (recur (+ i 1)))))
,,, (println "triple-to-x 2 6")  (triple-to-x 2 6) ; 6 \n 9 \n 12 \n 15 \n

(defn print-list
  [& nums]
  (doseq [x nums]
    (println x)))
(print-list 7 8 9)  ; 7 \n 8 ; 9 \name

,,, (println "file i/o:")
(use 'clojure.java.io)
(defn write-to-file
  [file text]
  (with-open [wrtr (writer file)]
    (.write wrtr text)))

(defn read-from-file
  [file]
  (try
    (println (slurp file))
  (catch Exception e (println "Error" (.getMessage e)))))

(defn append-to-file
  [file text]
  (with-open [wrtr (writer file :append true)]
    (.write wrtr text)))

(defn read-line-from-file
  [file]
  (with-open [rdr (reader file)]
    (doseq [line (line-seq rdr)]
      (println line))))

(write-to-file "mytxt.txt" "hi")
(append-to-file "mytxt.txt" "hello")
,,,(read-line-from-file "mytxt.txt")

,,, (println "destructuring:")
(defn destruct []
  (def vectVals [1 2 3 4])
  (let [[one two & the-rest] vectVals]
    (println one two the-rest)))
(destruct)  ; 1 2 (3 4)

,,, (println "struct map:")
(defn struct-map-ex []
  (defstruct Customer :Name :Phone)
  (def cust1 (struct Customer "Doug" "9495551212"))
  (def cust2 (struct-map Customer :Name "Sally" :Phone "5551212"))
  (println cust1)  ; {:Name Doug, :Phone 9495551212}
  (println (:Name cust2))  ; Sally
  )
(struct-map-ex)

,,, (println (map (fn [x] (* 3 x)) (range 1 5)))  ; (3 6 9 12)
,,, (println (map #(* % 3) (range 1 5)))  ; (3 6 9 12)
,,, (println (#(* %1 %2) 2 3))  ; 6

,,, (println "lambda:")
(defn custom-multiplier [mult-by]
  #(* % mult-by))
(def mult-by-3 (custom-multiplier 3))
,,, (println (mult-by-3 5))  ; 15

,,, (println "filter:")
(println (take 2 [1 2 3]))  ; (1 2)
(println (drop 1 [1 2 3]))  ; (2 3)
(println (take-while neg? [-1 0 1]))  ; (-1)
(println (drop-while neg? [-1 0 1]))  ; (0 1)
(println (filter #(> % 2) [1 2 3 4]))  ; (3 4)


,,, (println "macros:")
(defmacro discount
  ([cond dis1 dis2]
   (list `if cond dis1 dis2)))

(discount (> 25 65) (println "10% Off")
(println "Full Price"))  ; Full Price

(defmacro reg-math [calc]
  (list (second calc) (first calc) (nth calc 2)))
(println (reg-math (2 + 5)))  ; # 7

(defmacro do-more
  [cond & body]
  (list `if cond (cons 'do body)))
(do-more (< 1 2)
         (println "Hello")
         (println "Hello Again")
  )

(defmacro do-more-2 [cond & body]
  `(if ~cond (do ~@body)))
(do-more-2 (< 1 2)
         (println "Hello")
         (println "Hello Again")
  )


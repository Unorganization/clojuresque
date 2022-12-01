(ns clojuresque.all
  (:require [clojure.string :as str]) ; can use short name 'str'
  (:require [clojure.set :refer [union, difference, intersection, subset?]])
  (:gen-class))


,,,(println "deftype:")
,,,(deftype Rectangle [length width])
(def myRectangle1 (Rectangle. 5 11))
(def myRectangle2 (->Rectangle 9 4))

(println (.length myRectangle1))  ; 5
(println (.width myRectangle2))  ; 4


,,,(println "atoms:")
(def vx 5)
(def vatom (atom vx))
(println @vatom)  ; 5 
(swap! vatom (fn [x] (+ x 3)))
(println @vatom)  ; 8  

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
  (println "Increment x" @atomEx))
(atom-ex 5)

,,,(println "transactions / dosync")
(def vref1 (ref 5))
(def vref2 (ref 6))
(println @vref1 @vref2)  ; 5  6

(dosync
 (alter vref1 (fn [x] (+ x 3)))
 (alter vref2 (fn [x] (+ x 3))))
(println @vref1 @vref2)  ; 8 9

,,, (println "math stuff:")
,,, (println (+ 1 2 3))  ; 6
,,, (println (clojure.core/+ 1 2 3))  ; 6
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

(def my-ratio 100/8)
,,, (println (type my-ratio))  ; clojure.lang.Ratio
(println my-ratio)  ; 25/2
(println (numerator my-ratio))  ; 25
(def my-ratio2 (/ 100 8))
(println (denominator my-ratio2))  ; 2
(println (double my-ratio))  ; 12.5
(println (type (double my-ratio)))  ; java.lang.Double

(def my-ratio3 10/2)
(println my-ratio3)  ; 5
(println (ratio? my-ratio3))  ; false
,,, (println (type my-ratio3))  ; java.lang.Long


,,, (println "functions:")
(defn say-hello
  "Receives a name with 1 parameter and responds"
  [name]

  (println "Hello again" name))
(say-hello "bob")

(defn get-sum [x y]
  (+ x y))
,,, (println (get-sum 5 6))  ; 11

    ; multi-arity function
(defn get-sum-more
  ([x y z]
   (+ x y z))

  ([x y]
   (+ x y)))

,,, (println (get-sum-more 6 7))  ; 13
,,, (println (get-sum-more 5 6 7))  ; 18

; doseq iterations over a sequence; can support nested loops
(defn print-elems [first & rest]
  (println first)
  (doseq [arg rest] (println arg)))

(print-elems "First" "Second" 3 4 "Fifth")  ; First\nSecond\n3\n4\nFifth

(defn hello-you [name]
  (str "Hello " name))

(defn hello-all [& names]
  (map hello-you names))

,,,(println (hello-all "kenny" "michelle" "aaron"))
    ; (Hello kenny Hello michelle Hello aaron)

,,, (println "condition:")
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


(defn can-vote [age]
  (if (>= age 18)
    (println "You can vote")
    (println "You can't vote")))

,,, (println "can-vote 17")  (can-vote 17)  ; You can't vote
,,, (println "can-vote 18")  (can-vote 18)  ; You can vote
,,, (println "can-vote 19")  (can-vote 19)  ; You can vote

(defn can-do-more [age]
  (if (>= age 18)
    (do (println "You can drive")
        (println "You can vote"))
    (println "You can't vote")))
,,, (println "can-do-more 17")  (can-do-more 17)  ; You can drive
,,, (println "can-do-more 18")  (can-do-more 18)  ; You can vote
,,, (println "can-do-more 19")  (can-do-more 19)  ; You can vote

    ; when like if without else
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

; case
(defn case-ex1 [input-num]
  (case input-num
    1 "one"
    2 "two"
    3 "three"
    "don't know"))
(println (case-ex1 1))  ; one
(println (case-ex1 2))  ; two
(println (case-ex1 3))  ; three
(println (case-ex1 4))  ; don't know

; recur
(loop [i 0]
  (when (< i 5)
    (println i)
    (recur (inc i)); loop i will take this value
))  ; 0\n 1\n 2\n 3\n 4\n

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
,,, (calc-factorial2 5)  ; 120


,,, (println "looping:")
(defn one-to-x [x]
  (def i (atom 1))
  (while (<= @i x)
    (do
      (println @i)
      (swap! i inc))))
,,, (println "one-to-x 5")  (one-to-x 5)  ; 1 \n 2 \n 3 \n 4 \n 5 \n

    ; dotimes = used to run expression n times
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

(dotimes [n 5]
  (println (str "My number is: " n)))  ; My number is 0\n, etc. to 4 

    ; doseq output not captured
(doseq [num-one [1 2 3]
        num-two [4 5 6]]
  (println num-one " " num-two))  ; 1 4\n 1 5\n 1 6\n, 2 4\n 2 5\n etc. to 3 6\n

; for comprhension -- supports mult seqs, output captured
(println (for [num-one [1 2 3]
               num-two [4 5 6]]
           [num-one num-two]))  ; ([1 4] [1 5] [1 6] [2 4] [2 5] [2 6] [3 4] [3 5] [3 6])


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
(println (take 7 (cycle [1 2 3])))  ; (1 2 3 1 2 3 1)

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
         (println "Hello Again"))

(defmacro do-more-2 [cond & body]
  `(if ~cond (do ~@body)))
(do-more-2 (< 1 2)
           (println "Hello")
           (println "Hello Again"))

,,, (println "destructuring:")
(def apoint [5 7])
,,, (println apoint)  ; [5 7]
,,, (let [[x y] apoint] (println (+ x y)))  ; 12

;; with arg list
(def ndx [1 2 3])
,,, (println ndx)  ; [1 2 3]
,,, (let [[x & more] ndx] (println x more))  ; 1 (2 3)
,,, (let [[x & more :as full-list] ndx]
      (println x more full-list))  ; 1 (2 3) [1 2 3]
;; or 
,,, (def cpoint {:y 7})
,,, (println cpoint)  ;; {:y 7}
,,, (let [{:keys [x y] :or {x 0 y 0}} cpoint]
      (println "x:" x "y:" y))  ; x: 0 y: 7


(def bpoint {:x 5 :y 7})
,,, (println bpoint)  ; {:x 5, :y 7}
,,, (let [{x :x y :y} bpoint]
      (println "x:" x "y:" y))  ; x: 5 y: 7
,,, (let [{:keys [x y]} bpoint]
      (println "x:" x "y:" y))  ; x: 5 y: 7
,,, (let [{:keys [x y] :as the-point} bpoint]
      (println "x:" x "y:" y "point:" the-point))
      ; x: 5 y: 7 point: {:x 5, :y 7}

(def book {:name "SICP" :details {:pages 657 :isbn-10 "0262011530"}})
,,, (println book)  ; {:name SICP, :details {:pages 657, :isbn-10 0262011530}}
(let [{name :name {pages :pages isbn-10 :isbn-10} :details} book]
         (println "name:" name "pages:" pages "isbn-10:" isbn-10))
    ;;  name: SICP pages: 657 isbn-10: 0262011530

(def nested_vector [[1 2][3 4]])
,,, (println nested_vector)  ;; [[1 2] [3 4]]
(let [[[a b][c d]] nested_vector]
  (println "a:" a "b:" b "c:" c "d:" d))  ;; a: 1 b: 2 c: 3 d: 4

; destructure both map and vecotr
(def golfer {:name "Jim" :scores [3 5 4 5]})
    (let [{name :name [hole1 hole2] :scores} golfer] 
         (println "name:" name "hole1:" hole1 "hole2:" hole2))
    ;; name: Jim hole1: 3 hole2: 5 
    
; destructuring in function def
(defn print-status [{name :name [hole1 hole2] :scores}] 
  (println "name:" name "hole1:" hole1 "hole2:" hole2))
(print-status {:name "Jim" :scores [3 5 4 5]})
  ;; name: Jim hole1: 3 hole2: 5


;; (def light-phases 
;;   [#{:green}
;;    #{:yellow}
;;    #{:red :yellow}])

;; (def next-phase)

;; (println light-phases)
;; (println (cycle light-phases))

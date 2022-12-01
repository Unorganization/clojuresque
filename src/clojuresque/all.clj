(ns clojuresque.all
  (:require [clojure.string :as str]) ; can use short name 'str'
  (:require [clojure.set :refer [union, difference, intersection, subset?]])
  (:gen-class))
    

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

(def nested_vector [[1 2] [3 4]])
,,, (println nested_vector)  ;; [[1 2] [3 4]]
(let [[[a b] [c d]] nested_vector]
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

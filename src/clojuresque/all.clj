(ns clojuresque.all
  (:require [clojure.string :as str]) ; can use short name 'str'
  (:require [clojure.set :refer [union, difference, intersection, subset?]])
  (:gen-class))
    

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


;; (def light-phases 
;;   [#{:green}
;;    #{:yellow}
;;    #{:red :yellow}])

;; (def next-phase)

;; (println light-phases)
;; (println (cycle light-phases))

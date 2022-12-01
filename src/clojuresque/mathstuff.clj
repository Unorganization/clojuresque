(ns clojuresque.mathstuff)


(def my-ratio 100/8)
(def my-ratio2 (/ 100 8))
(def my-ratio3 10/2)

(defn mathstuff []
  (println "math stuff:")
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

  ,,, (println (type my-ratio))  ; clojure.lang.Ratio
  (println my-ratio)  ; 25/2
  (println (numerator my-ratio))  ; 25
  (println (denominator my-ratio2))  ; 2
  (println (double my-ratio))  ; 12.5
  (println (type (double my-ratio)))  ; java.lang.Double

  (println my-ratio3)  ; 5
  (println (ratio? my-ratio3))  ; false
  ,,, (println (type my-ratio3))  ; java.lang.Long
  )

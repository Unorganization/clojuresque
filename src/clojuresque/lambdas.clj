(ns clojuresque.lambdas)

(defn custom-multiplier [mult-by]
  #(* % mult-by))
(def mult-by-3 (custom-multiplier 3))


(defn lambdas []
  ,,, (println "lambda:")

  ,,, (println (mult-by-3 5))  ; 15

  ,,, (println (map (fn [x] (* 3 x)) (range 1 5)))  ; (3 6 9 12)
  ,,, (println (map #(* % 3) (range 1 5)))  ; (3 6 9 12)
  ,,, (println (#(* %1 %2) 2 3))  ; 6
  )
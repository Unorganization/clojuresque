(ns clojuresque.transactions)

(def vref1 (ref 5))
(def vref2 (ref 6))

(defn transactions []
  ,,,(println "transactions / dosync")
  (println @vref1 @vref2)  ; 5  6

  (dosync
   (alter vref1 (fn [x] (+ x 3)))
   (alter vref2 (fn [x] (+ x 3))))
  (println @vref1 @vref2)  ; 8 9
  )
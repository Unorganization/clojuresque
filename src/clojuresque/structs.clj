(ns clojuresque.structs)


(defstruct Customer :Name :Phone)
(def cust1 (struct Customer "Doug" "9495551212"))
(def cust2 (struct-map Customer :Name "Sally" :Phone "5551212"))

(defn struct-map-ex []
  (println cust1)  ; {:Name Doug, :Phone 9495551212}
  (println (:Name cust2))  ; Sally
  )

(defn structs []
  ,,, (println "struct map:")
  (struct-map-ex))
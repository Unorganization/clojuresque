(ns clojuresque.records)

(defrecord CarModel [make model])
(def fiat-500 (->CarModel "Fiat" "500"))
(def ford-focus (map->CarModel {:make "Ford"  :model "Focus"}))
(def nocar (map->CarModel {}))

(defn records []
  (println (:make fiat-500))  ; "Fiat"
  (println (:model fiat-500))  ; "500"

  (println (:make ford-focus))  ; "Ford"
  (println (:model ford-focus))  ; "Focus"

  (println (:make nocar))  ; "nil"
  (println (:model nocar))  ; "nil"

  (println (class CarModel))  ; clojuresque.all.CarModel

  (println (type :make))   ; clojure.lang.Keyword
  )


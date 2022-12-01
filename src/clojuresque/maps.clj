(ns clojuresque.maps)

(def map1 {"b" 6 "a" 5})

(def mapx (zipmap [1 2 3] [11 22 33]))
(def mapx2 (zipmap [1 2 3] [11 22]))

(def jeep-wrangler {:make "Jeep" :model "Wrangler"})

(defn maps []
  ,,,(println "maps:")
  ,,, (println (hash-map "y" 3 "x" 4))   ; {x 4, y 3}
  ,,, (println (sorted-map "y" 3 "x" 4))  ; {x 4, y 3}
  ,,, (println map1)  ; {a 6, b 5}
  ,,, (println (get map1 "b"))  ; 6
  ,,, (println (find map1 "b"))  ; [b 6]
  ,,, (println (contains? map1 "b"))  ; true
  ,,, (println (keys map1))  ; (b, a)
  ,,, (println (vals map1))  ; (6 5)
  ,,, (println (merge map1 (hash-map "y" 3 "x" 4)))  ; {b 6, a 5, x 4, y 3}
  ,,, (println (merge-with + map1 (hash-map "y" 3 "x" 4)))  ; {b 6, a 5, x 4, y 3}

      ; add to an existing map
  (println (assoc map1 "c" 4))  ; {b 6, a 5, c 4}
  (println (dissoc map1 "b"))  ; {a 5,}

  (println mapx)  ; {1 11, 2 22, 3 33}
  (println mapx2)  ; {1 11, 2 22}
  
  ,,, (println "maps using keywords")
  (println jeep-wrangler)  ; {:make Jeep, :model Wrangler}
  (println (get jeep-wrangler :make))  ; "Jeep"
  (println (:make jeep-wrangler))  ; "Jeep"
  (println (:model jeep-wrangler))  ; "Wrangler"
  (println (class jeep-wrangler))  ; clojure.lang.PersistentArrayMap
  )

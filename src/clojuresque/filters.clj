(ns clojuresque.filters)

(defn filters []
  ,,, (println "filter:")
  (println (take 2 [1 2 3]))  ; (1 2)
  (println (drop 1 [1 2 3]))  ; (2 3)
  (println (take-while neg? [-1 0 1]))  ; (-1)
  (println (drop-while neg? [-1 0 1]))  ; (0 1)
  (println (filter #(> % 2) [1 2 3 4]))  ; (3 4)
  (println (take 7 (cycle [1 2 3])))  ; (1 2 3 1 2 3 1)
  )
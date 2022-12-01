(ns clojuresque.vectors)

(def vec1 [1 2 3 "Cat"])

(defn vectors []
  ,,,(println "vectors:")
  ,,, (println (vector 1 2 3))  ; [1 2 3 ]
  ,,, (println vec1)  ; [1 2 3 Cat]
  ,,, (println (get vec1 3))  ; Cat
  ,,, (println (conj vec1 3))  ; [ 1 2 3 Cat 3 ]
  ,,, (println (pop vec1))  ; [1 2 3]
  ,,, (println (subvec [99 88 77 66 55] 2 4))  ; [77 66]
  ,,, (println (assoc vec1 1 99))  ; [1 99 3 Cat]
  ,,, (println (subvec vec1 1 3))  ; [2 3] 
  ,,, (println (subvec vec1 1))  ; [2 3 Cat] 
  ,,, (println (vector? vec1))  ; true
  ,,, (println (list? vec1))  ; false
  )
  
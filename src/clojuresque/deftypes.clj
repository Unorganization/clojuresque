(ns clojuresque.deftypes)

,,,(deftype Rectangle [length width])
(def myRectangle1 (Rectangle. 5 11))
(def myRectangle2 (->Rectangle 9 4))

(defn deftypes []
  ,,,(println "deftype:")
  (println (.length myRectangle1))  ; 5
  (println (.width myRectangle2))  ; 4
  )
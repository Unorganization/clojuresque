(ns clojuresque.numbers)

(def myint 10)
(def mydbl 3.14)

(defn numbers []
  ,,,(println "numbers:")
  ,,,(println myint)
  ,,,(println (type myint))  ; java.lang.Long
  ,,,(println mydbl)
  ,,,(println (type mydbl))  ; java.lang.Double
  ,,,(println (nil? mydbl))  ; test for nil
  ,,,(println (pos? -1) (neg? -1)  ; test for positive or negative value
              (even? -1) (odd? -1)  ; test for even or odd
              (number? -1) (integer? -1)  ; is number?  is float 
              (zero? -1)  ; is zero
              ))
(ns clojuresque.macros)

(defmacro discount
  ([cond dis1 dis2]
   (list `if cond dis1 dis2)))

(defmacro reg-math [calc]
  (list (second calc) (first calc) (nth calc 2)))

(defmacro do-more
  [cond & body]
  (list `if cond (cons 'do body)))

(defmacro do-more-2 [cond & body]
  `(if ~cond (do ~@body)))


(defn macros []
  ,,, (println "macros:")
  (discount (> 25 65) (println "10% Off")
            (println "Full Price"))  ; Full Price

  (println (reg-math (2 + 5)))  ; # 7
  
  (do-more (< 1 2)
           (println "Hello")
           (println "Hello Again"))

  (do-more-2 (< 1 2)
             (println "Hello")
             (println "Hello Again")))
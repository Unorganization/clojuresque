(ns clojuresque.agent-try)

,,, (println "agents:")
(defn agent-ex []
  (def tickets-sold (agent 0))

  (send tickets-sold + 15)
  (await-for 100 tickets-sold)
  (println "Tickets: " @tickets-sold)

  (send tickets-sold + 10)
  (await-for 100 tickets-sold)
  (println "Tickets: " @tickets-sold)

  (shutdown-agents)
  )
;; (agent-ex) 
  ;; (agent-try/agent-ex)
    


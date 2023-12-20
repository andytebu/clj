(ns learn-clojure-tutorial.functions)
;; https://clojure.org/guides/learn/functions

;; 6) Define a function greet that takes no arguments and prints "Hello". Replace the ___ with the implementation: (defn greet [] _)
(defn greet [] (println "Hello"))
(greet)

;; using fn
(def greet-fn (fn [] (println "Hello")))
(greet-fn)

;; using #()
(def greet-h #(println "Hello"))
(greet-h)

;; Hint use the str function to concatenate strings

(require '[clojure.repl :as repl :refer [doc find-doc source pst]])
(doc str)

(defn greeting
  ([] (str "Hello, World!"))
  ([x] (str "Hello, " x "!"))
  ([x y] (str x ", " y "!")))

;; For testing
(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

;; 5) Define a function do-nothing which takes a single argument x and returns it, unchanged.
(defn do-nothing
  [x] x)
(do-nothing 13)

;; In Clojure, this is the identity function. By itself, identity is not very useful, but it is sometimes necessary when working with higher-order functions.
(source identity)

;; 6) Define a function always-thing which takes any number of arguments, ignores all of them, and returns the number 100.
(defn always-thing
  [& _] 100)
(always-thing)

;; 7) Define a function make-thingy which takes a single argument x. It should return another function, which takes any number of arguments and always returns x.
(defn make-thingy
  [x]
  (fn [& _] x))

;; Tests
(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f 123)))
  (assert (= n (apply f 123 (range)))))

;; In Clojure, this is the constantly function.
(source constantly)

;; 8) Define a function triplicate which takes another function and calls it three times, without any arguments.
(defn triplicate
  [f] (f) (f)
  (f))

(triplicate greet)


;; 9) Define a function opposite which takes a single argument f. It should return another function which takes any number of arguments, applies f on them, and then calls not on the result. The not function in Clojure does logical negation
(defn opposite [f]
  (fn [& args]
    (not
     (apply f args))))

(defn is-even? [x]
  (zero? (rem x 2)))

((opposite complement) '(true false false false true))
((opposite is-even?) 13)
((opposite is-even?) 14)

(defn triplicate2 [f & args]
  (triplicate (fn [] (apply f args))))

(triplicate2 (fn [& args] (apply * args)) 1 2 3 4 5 6 7 8 9)

;; 10) Using the java.lang.Math class (Math/pow, Math/cos, Math/sin, Math/PI), demonstrate the following mathematical facts:

(Math/cos Math/PI)

(+ (Math/pow (Math/sin 0.2) 2)
   (Math/pow (Math/cos 0.2) 2))

;; 11) Define a function that takes an HTTP URL as a string, fetches that URL from the web, and returns the content as a string.

;; Hint: You can use the slurp function to fetch the URL contents as a string.

(defn http-get [url]
  ;; (java.net.URL. url)
  (slurp url))

(assert (.contains (http-get "https://www.w3.org") "html"))

(doc slurp)

;; 12) Define a function one-less-arg that takes two arguments:
;; f, a function

;; x, a value
;; and returns another function which calls f on x plus any additional arguments.


(defn one-less-arg [f x]
  (fn [& args] (apply f x args)))

((one-less-arg + 1) 1 2 3)

;; 13) Define a function two-fns which takes two functions as arguments, f and g. 
;; It returns another function which takes one argument, calls g on it, then calls f on the result, and returns that.

;; That is, your function returns the composition of f and g.

(defn two-fns [f g]
  (fn [x] (f (g x))))

((two-fns + inc) 1)
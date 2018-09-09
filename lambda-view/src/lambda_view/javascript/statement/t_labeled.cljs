;; ESTree Spec
;; https://github.com/estree/estree

(ns lambda-view.javascript.statement.t-labeled
  (:require [lambda-view.utils :as utils])
  (:use [lambda-view.javascript.render :only [render-node
                                            render-node-coll]]
        [lambda-view.javascript.common :only [js-keyword
                                   white-space
                                   white-space-optional
                                   asterisk
                                   comma
                                   colon
                                   equal
                                   common-list
                                   collapsable-box]]
        [lambda-view.tag :only [id-of]]
        [lambda-view.state :only [init-collapse!
                                  init-layout!]]))

;; LabeledStatement
(defn render [node]
  (let [label (get node "label")
        body (get node "body")]
    [:div {:class "labeled statement"}
     [:div {:class "label"} (render-node label)]
     (colon)
     (white-space-optional)
     [:div {:class "body"} (render-node body)]]))
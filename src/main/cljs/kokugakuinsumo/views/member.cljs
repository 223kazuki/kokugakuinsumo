(ns kokugakuinsumo.views.member
  (:require [reagent.core :refer [create-class]]
            [re-frame.core :as r]
            [kokugakuinsumo.views.components :as c]))

;; const Member = React.createClass({
;;   render() {
;;     var memberNodes = this.props.data.map(function(member) {
;;       var introNode = member.introductioncontent.split('\\n').map(function(str) {
;;         return (
;;           <div key={str}>
;;             {str}<br/>
;;           </div>
;;         );
;;       });
;;       var toTop = function () {
;;         $('html, body').animate({ scrollTop: 0 }, 'fast');
;;         return false;
;;       };
;;       return (
;;         <Element name={member.id} key={member.id} className="element">
;;           <Row>
;;             <Col xs={6} md={6}>
;;               <Thumbnail src={member.image} ></Thumbnail>
;;             </Col>
;;             <Col xs={6} md={6} className="caption">
;;               <h3><span className="name">{member.name}</span><span className="yomi">{member.pronunciation}</span></h3>
;;               <h4>身長/体重</h4>
;;               {member.height + "/" + member.weight}
;;               <h4>{member.introductiontitle}</h4>
;;               {introNode}
;;               <p className="toTop" onClick={toTop}>部員一覧へ戻る</p>
;;             </Col>
;;           </Row>
;;         </Element>
;;       );
;;     });
;;     return (
;;       <Col xs={12} md={12} className="member">
;;         {memberNodes}
;;       </Col>
;;     );
;;   }
;; });

;; const MemberList = React.createClass({
;;   render() {
;;     var toMember = function (id) {
;;       scroller.scrollTo(id, true, 300, -50);
;;     };
;;     var memberNodes = this.props.data.map(function(member) {
;;       return (
;;         <tr className="fromMember" key={member.id} onClick={toMember.bind(this, member.id)}>
;;           <td>{member.grade}</td>
;;           <td>{member.post}</td>
;;           <td>{member.name}</td>
;;           <td>{member.affiliation}</td>
;;           <td>{member.birthplace}</td>
;;         </tr>
;;       );
;;     });
;;     return (
;;       <tbody>
;;         {memberNodes}
;;       </tbody>
;;     );
;;   }
;; });

;; let MemberComponent = React.createClass({
;;   getInitialState() {
;;     return {data: []};
;;   },
;;   loadAjax() {
;;     $.ajax({
;;       url: '/data/member.json',
;;       dataType: 'json',
;;       success: function(data) {
;;         this.setState({data: data});
;;       }.bind(this),
;;       error: function(xhr, status, err) {
;;         console.error(this.props.url, status, err.toString());
;;       }.bind(this)
;;     });
;;   },
;;   componentDidMount() {
;;     this.loadAjax();
;;   },
;;   render() {
;;     return (
;;       <div className="member-component">
;;         <Row>
;;           <Col xs={12} md={12}>
;;             <h1>部員紹介</h1>
;;           </Col>
;;           <Col xs={12} md={12}>
;;             <table id="memberHeader">
;;               <thead>
;;                 <tr>
;;                   <th>学年</th>
;;                   <th>役職</th>
;;                   <th>名前</th>
;;                   <th>所属</th>
;;                   <th>出身地</th>
;;                 </tr>
;;               </thead>
;;               <MemberList data={this.state.data} />
;;             </table>
;;           </Col>
;;           <Col xs={12} md={12} id="memberBody">
;;             <Member data={this.state.data}/>
;;           </Col>
;;         </Row>
;;       </div>
;;     );
;;   }
;; });

(defn member [member]
  [:div {:class "element"}
   [c/row
    [c/col {:xs 6 :md 6}
     [c/thumbnail {:src (:image member)}]]
    [c/col {:xs 6 :md 6 :class "caption"}
     [:h3
      [:span {:class "name"} (:name member)]
      [:span {:class "yomi"} (:pronunciation member)]]
     [:h4 "身長/体重"]
     (str (:height member) " / " (:weight member))
     [:h4 (:introductiontitle member)]
     (for [r (-> member
                  :introductioncontent
                  (clojure.string/split #"\\n"))]
       [:div {:key r} [:span r] [:br]])

     [:p {:class "toTop", :on-click nil} "部員一覧へ戻る"]]]])

(defn member-list [members]
  [:table {:id "memberHeader"}
   [:thead
    [:tr
     [:th "学年"]
     [:th "役職"]
     [:th "名前"]
     [:th "所属"]
     [:th "出身地"]]]
   [:tbody
    (for [m members]
      [:tr {:class "fromMember" :key (:id m) :on-click nil}
       [:td (:grade m)]
       [:td (:post m)]
       [:td (:name m)]
       [:td (:affiliation m)]
       [:td (:birthplace m)]])]])

(defn member-page []
  (create-class
    {:component-will-mount
     (fn []
       (r/dispatch [:get-members]))
     :reagent-render
     (fn []
       (let [members @(r/subscribe [:members])]
         [:div {:id "member"}
          [c/row
           [c/col {:xs 12 :md 12}
            [:h1 "部員紹介"]]
           (when-not (nil? members)
             [:div
              [c/col {:xs 12 :md 12}
               [member-list members]]
              [c/col {:xs 12 :md 12 :id "memberBody"}
               (for [m members]
                 [:div {:key (:id m)}
                  [member m]])]])]]))}))

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<div class="side_block" style="width:1040px; margin: 50px auto 0px">

    <button>OK</button>
    <%--<div class="post_content" postId="${post.id}" id="post_content">--%>
        <%--<p class="f18">${post.header}--%>
            <%--<c:if test="${isAuthored == true}">--%>
                <%--<a class="edit_input_link pull-right" href="#" id="delete_story"><img alt="" src="/img/del_link.png"></a>--%>
                <%--<a class="edit_input_link pull-right" href="#" id="edit_story"><img alt="" src="/img/interests_edit.png"></a>--%>
            <%--</c:if>--%>
        <%--</p>--%>
        <%--<img src="${post.originalImage}" alt=""/>--%>

        <%--<div class="post_tags_wrap" id="post_tags_wrap">--%>
            <%--<!-- TODO: Refactor view to show trendss -->--%>
            <%--<c:forEach items="${post.trends}" var="entry">--%>
                <%--<div class="post_tag_item">--%>
                    <%--<a href="/interest/trend/${entry}" class="green tags_link" data-target="#${entry.text}">${entry.text}</a>--%>
                <%--</div>--%>
            <%--</c:forEach>--%>
        <%--</div>--%>
        <%--<p class="f12">${post.content}</p>--%>
    <%--</div>--%>
    <%--<div id="refactor_story" style="display: none">--%>
        <%--<form:form id="add" action="/interest/${post.id}/change" modelAttribute="post" enctype="multipart/form-data" method="post">--%>
            <%--<input type="hidden" name="_csrf" value="<c:out value="${_csrf.token}" />"/>--%>
            <%--<fieldset>--%>
                <%--<div class="add_post_content">--%>
                    <%--<p class="f16">Add or change interest:</p>--%>

                    <%--<div class="add_interest_wrap clearfix">--%>
                        <%--<div class="add_interest_left pull-left">--%>
                            <%--<div class="interest_tags_wrap clearfix">--%>
                                <%--<div class="interest_tags_select pull-left">--%>
                                    <%--<span class="interest_info">&nbsp;</span>--%>
                                    <%--<form:select data-placeholder="Choose an interest..."--%>
                                                 <%--path="trends"--%>
                                                 <%--items="${trends}"--%>
                                                 <%--itemLabel="text"--%>
                                                 <%--cssClass="chosen-select"--%>
                                                 <%--cssStyle="width:385px;"--%>
                                                 <%--multiple="true">--%>
                                    <%--</form:select>--%>
                                    <%--<form:errors path="trends"/>--%>
                                <%--</div>--%>
                                <%--<div class="interest_tags_items pull-left"></div>--%>
                            <%--</div>--%>
                            <%--<div class="interest_header_desc">--%>
                                <%--<p>Header:</p>--%>
                                <%--<form:input type="text" name="header" path="header"/>--%>
                                <%--<form:errors path="header"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="add_interest_right pull-left">--%>
                            <%--<div class="add_cover_wrap">--%>
                                <%--<img src="${post.coverImage}" alt="" id="storyImg" class="storyImg">--%>
                                <%--<a href="#" class="add_cover" onclick="$(this).next().click();return false;" id="">Add--%>
                                    <%--cover--%>
                                    <%--story</a>--%>
                                <%--<form:input type="file" class="hide" id="originalImage" name="originalImage"--%>
                                            <%--path="originalImage" accept='image/*'/>--%>
                                <%--<form:input type="hidden" name="newImage" id="newImage" data-newImage="${post.newImage}"--%>
                                            <%--path="newImage" />--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<form:errors path="content"/>--%>
                    <%--<div class="textarea_wrap">--%>
                        <%--<form:textarea placeholder="" cols="" rows="10" name="content" path="content"/>--%>
                    <%--</div>--%>
                    <%--<div class="add_interest_wrap clearfix">--%>
                        <%--<div class="add_interest_right pull-left">--%>
                            <%--<button id="cancel" class="button">Cancel</button>--%>
                        <%--</div>--%>
                        <%--<div class="add_interest_right pull-right">--%>
                            <%--<button id="add_post" class="button red">Change story</button>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</fieldset>--%>
        <%--</form:form>--%>
    <%--</div>--%>
    <%--<div class="post_footer">--%>
        <%--Wrote--%>
        <%--<a href="#" id="author_name" class="green" data-author_id="${post.authorId}">${post.authorName}</a>--%>

        <%--<span class="post_time gray">${post.wasCreated}</span>--%>

        <%--<div class="post_item_counter clearfix">--%>

            <%--<div class="counter_item pull-left">--%>
                <%--<span class="view ico">&nbsp;</span><span class="counter">${post.viewCount}</span>--%>
            <%--</div>--%>

        <%--</div>--%>

    <%--</div>--%>

    <%--<div  class="smollPopupWrap" id="removed_post">--%>
        <%--<div class="smollPopupContent">--%>
            <%--<a href="#" class="b-close">&nbsp;</a>--%>
            <%--<div class="smollPopupContentMessage">--%>
                <%--<div class="smollPopupContentIcoWrap clearfix">--%>
                    <%--<span class="smollPopupContentText smoll_top">Your story was successfully deleted</span>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div id="disqus_thread"  style="padding: 0px 20px;"></div>--%>
    <%--<script type="text/javascript">--%>
        <%--/* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */--%>
        <%--var disqus_shortname = 'rainbowedsocial'; // required: replace example with your forum shortname--%>

        <%--/* * * DON'T EDIT BELOW THIS LINE * * */--%>
        <%--(function() {--%>
            <%--var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;--%>
            <%--dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';--%>
            <%--(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);--%>
        <%--})();--%>
    <%--</script>--%>
    <%--<noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>--%>

</div>
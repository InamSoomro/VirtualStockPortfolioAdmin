<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
 <h2>Welcome to Portfolio Administration System</h2>
<article>
<center>
<br/>
	<div class="content-area">
		<fieldset>
        <legend>Transactions</legend>
       <table>
       <tr><td>
       <h2>	<a href="<c:url value="portfolio.htm"/>">Retrieve Data</a><span></span></h2></td>
       <td><h2>	<a href="<c:url value="viewtransactions.htm"/>">See Recent Transactions</a><span></span></h2>
	        		</td></tr>
	     </table>
	  	</fieldset>
  	   <fieldset>
        <legend>Info</legend>
        
        <table width="100%">
            <tbody>

                <tr>
                    <th>Date Created</th>
                    <td class="numeric"><c:out value="${pItem.now}"/></td>
                </tr>
				<tr>
                    <th>Startup Capital</th>
                    <td class="numeric">100000
                    </td>
                </tr>
                <tr><td><hr></hr></td></tr>
                <tr>
                    <th>Available Cash</th>
                    <td class="numeric"><strong><c:out value="${pItem.startupcapital}"/></strong></td>
                </tr>
                
            </tbody>
        </table>

    </fieldset>
		<table width="100%"  border="0" cellspacing="1" cellpadding="2" >
			<tr height="20px"></tr>
			<tr class="HeadingColor" height="40px">
 				<th class="GridHeadings">Company</th>
 				<th class="GridHeadings">Symbol</th>
 				<th class="GridHeadings">Shares</th>
 				<th class="GridHeadings">Buying</th>
 				<th class="GridHeadings">Selling</th>
 				<th class="GridHeadings">Action</th>
			</tr>
			<c:forEach var="p" varStatus="pIndex" items="${pItem.pItems}">
        		<c:choose>
        			<c:when test="${pIndex.index%2==0}">
        			<tr  class="GridRowOne">
        			<td><c:out value="${p.company}"/></td>
        			<td><c:out value="${p.symbol}"/></td>
        			<td><c:out value="${p.shares}"/></td>
        			<td><c:out value="${p.buying}"/></td>
        			<td><c:out value="${p.selling}"/></td>
        			<td><a href="<c:url value="transaction.htm?id=${p.id}&TransactionType=BUY"/>">Buy</a><span>|</span>
        			<a href="<c:url value="transaction.htm?id=${p.id}&TransactionType=SELL"/>">Sell</a></d>
        		</tr>
        			</c:when>
        			<c:otherwise>
        			<tr  class="GridRowTwo">
        			<td><c:out value="${p.company}"/></td>
        			<td><c:out value="${p.symbol}"/></td>
        			<td><c:out value="${p.shares}"/></td>
        			<td><c:out value="${p.buying}"/></td>
        			<td><c:out value="${p.selling}"/></td>
        			<td><a href="<c:url value="transaction.htm?id=${p.id}&TransactionType=BUY"/>">Buy</a>|
        			<a href="<c:url value="transaction.htm?id=${p.id}&TransactionType=SELL"/>">Sell</a></d>
        			
        		</tr>
        			</c:otherwise>
        		</c:choose>
        		
        	</c:forEach>
			
	 	</table>
       
	
	</div><!-- Ending DIV of Content Area !-->	
	<hr></hr>
	
	
	
	
<script type="text/javascript">
var urlToLike = '';
	if (urlToLike == '') {
            urlToLike = window.location.href;
      }
      urlToLike = encodeURIComponent(urlToLike);

      var font = encodeURIComponent('inherit');


document.write ('<iframe src="http://www.facebook.com/widgets/like.php?locale=en_US&amp;href='+urlToLike+'&amp;layout=standard&amp;show_faces=true&amp;width=450&amp;height=150&amp;action=like&amp;font='+font+'&amp;colorscheme=light" scrolling="no" frameborder="0" allowTransparency="true" style="border:none; border-color:#ffffff; overflow:hidden; width:450; height:150"></iframe>')
</script>	
	
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	
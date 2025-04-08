<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<h2>Recent Transactions</h2>
<article>
<center>
<br/>
		
	<div class="content-area">
	<fieldset>
        <legend>Go To Portfolio</legend>
       <table>
		<tr><td>
	        		<h2><a href="<c:url value="portfolio.htm"/>">Go to Portfolio</a><span></span></h2>
	        		</td></tr>
	     </table>
	  	</fieldset>
	   
    </fieldset>
		<table width="100%"  border="0" cellspacing="1" cellpadding="2" >
			<tr height="20px"></tr>
			<tr class="HeadingColor" height="40px">
 				<th class="GridHeadings">Company Name</th>
 				<th class="GridHeadings">Symbol</th>
 				<th class="GridHeadings">Shares</th>
 				<th class="GridHeadings">Transaction Type</th>
 				<th class="GridHeadings">Total</th>
 				<th class="GridHeadings">Subtotal</th>
 				<th class="GridHeadings">Brokerage</th>
 				<th class="GridHeadings">Transaction Date</th>
 			</tr>
			<c:forEach var="p" varStatus="pIndex" items="${transactionbean}">
        		<c:choose>
        			<c:when test="${pIndex.index%2==0}">
        			<tr  class="GridRowOne">
	        			<td><c:out value="${p.companyName}"/></td>
	        			<td><c:out value="${p.symbol}"/></td>
	        			<td><c:out value="${p.quantity}"/></td>
	        			<td><c:out value="${p.transactionType}"/></td>
	        			<td><c:out value="${p.total}"/></td>
	        			<td><c:out value="${p.subtotal}"/></td>
	        			<td><c:out value="${p.brokarage}"/></td>
	        			<td><c:out value="${p.transactionDate}"/></td>
	        		</tr>
        			</c:when>
        			<c:otherwise>
        			<tr  class="GridRowTwo">
        				<td><c:out value="${p.companyName}"/></td>
	        			<td><c:out value="${p.symbol}"/></td>
	        			<td><c:out value="${p.quantity}"/></td>
	        			<td><c:out value="${p.transactionType}"/></td>
	        			<td><c:out value="${p.total}"/></td>
	        			<td><c:out value="${p.subtotal}"/></td>
	        			<td><c:out value="${p.brokarage}"/></td>
	        			<td><c:out value="${p.transactionDate}"/></td>
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
	
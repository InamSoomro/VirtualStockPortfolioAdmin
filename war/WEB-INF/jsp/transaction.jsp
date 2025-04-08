<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<h2>Welcome to Portfolio Administration System</h2>
<article>
<center>
<br/>
<form method="post">	
<c:set var="transactionType" value="<%= request.getParameter(\"TransactionType\").equals(\"BUY\") %>" /> 
	<div class="content-area">
	
	  	Make Transaction
		
		<table width="100%"  border="0" cellspacing="1" cellpadding="2" >
			<tr height="20px"></tr>
			<tr class="HeadingColor" height="40px">
 				<th class="GridHeadings">Company</th>
 				<th class="GridHeadings">Symbol</th>
 				<th class="GridHeadings">Shares</th>
 				<c:choose>
        			<c:when test="${transactionType}">
 				
 				<th class="GridHeadings">Buying</th>
 					</c:when>
        			<c:otherwise>
        			<th class="GridHeadings">Selling</th>
        				</c:otherwise>
        		</c:choose>
 			</tr>
	 				<tr  class="GridRowOne">
	 				<td><c:out value="${pItem.company}"/></td>
        			<td><c:out value="${pItem.symbol}"/></td>
        			<td><c:out value="${pItem.shares}"/></td>
        			<c:choose>
        			<c:when test="${transactionType}">
        			<td><c:out value="${pItem.buying}"/></td>
        			</c:when>
        			<c:otherwise>
        			<td><c:out value="${pItem.selling}"/></td>
        			</c:otherwise>
        		</c:choose>
        		</tr>
        		<tr>
      		<td ></td>
      		<td ><span>Quantity</span><input type="text" id="quantity" name="quantity" value="" />
      			    </td>
        	</tr>
        	
        	<tr>
        	<td>
        	         <a href="<c:url value="portfolio.htm"/>">Cancel |</a>
        			<a href="<c:url value="processOrder.htm?id=${pItem.id}"/>">Process Order</a>
        	         
        	           </td><td></td>
     </tr>   	           
        	        
    
        	
 		</table>
      </legend>
   </fieldset> 
       
	
	</div><!-- Ending DIV of Content Area !-->	
	</form>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<h2>Welcome to Portfolio Administration System</h2>
<article>
<center>
<br/>
			
		<c:out value="${model.now}"/>
	<div class="content-area">
		<table width="100%"  border="0" cellspacing="1" cellpadding="2" >
			<tr>
				<td>
<fieldset>
        <legend>Info</legend>
        
        <table width="100%">
            <tbody>

                <tr>
                    <th>Date Created</th>
                    <td class="numeric"><c:out value="${itemDetailMap.currentDate}"/></td>
                </tr>
				<tr>
                    <th>Product Info</th>
                    <td class="numeric"><c:out value="${itemDetailMap.portfolioItem.company}"/>,
                    					<c:out value="${itemDetailMap.portfolioItem.symbol}"/>
                    </td>
                </tr>
                <tr>
                    <th>Transaction Type</th>
                    <td class="numeric"><c:out value="${itemDetailMap.portfolioItemTransaction.transactionType}"/></td>
                </tr>
                
            </tbody>
        </table>

    </fieldset>

</div>    
<div id="order-details-description" class="group-content">
    <fieldset>
        <legend>Order Details</legend>
        <table width="100%">
            <tbody>
                <tr>
                    <td colspan="2">
					<table width="100%">

						<thead>
							<tr>
								<th width="20%">Symbol</th>
								<th class="numeric">Unit price</th>
								<th style="text-align: centre !important">Quantity</th>
								<th width="30" class="numeric"><strong>Total</strong></th>
							</tr>

						</thead>
						<tbody>
							<tr>
								<td style="width:auto">
								<small> <strong><c:out value="${itemDetailMap.portfolioItem.symbol}"/></strong> </small>

								</td>
								<td class="numeric unitprice">&euro; <c:out value="${itemDetailMap.portfolioItem.buying}"/></td>
								<td style= "vertical-align: middle"; class="numeric quantity"><c:out value="${itemDetailMap.portfolioItemTransaction.quantity}"/></td>
								<td class="numeric total">&euro; <c:out value="${itemDetailMap.portfolioItemTransaction.total}"/></td>
							</tr>
						</tbody>

					</table>
					</td>
                </tr>
                <tr>
                    <td colspan="2"><hr /></td>
                </tr>
                <tr>
                    <th>Subtotal</th>

                    <td class="numeric">&euro; <c:out value="${itemDetailMap.portfolioItemTransaction.subtotal}"/></td>
                </tr>
                <tr>
                    <th>Brokerage fee</th>
                    <td class="numeric">&euro; <c:out value="${itemDetailMap.portfolioItemTransaction.brokarage}"/></td>
                </tr>

                <tr>
                    <th>Tax</th>
                    <td class="numeric">&euro; <c:out value="${itemDetailMap.portfolioItemTransaction.tax}"/></td>
                </tr>
                <tr>
                    <th><strong>Total Amount (EUR)</strong></th>
                    <td class="numeric">

                        <strong>&euro; <c:out value="${itemDetailMap.portfolioItemTransaction.total}"/></strong>
                    </td>
                </tr>
            </tbody>
        </table>

    </fieldset>
</div>
				</td>
			</tr>
			<tr>
				<td><a style="text-align: left !important" href="<c:url value="portfolio.htm"/>">Cancel |</a>
				<a style="text-align: right !important" href="<c:url value="executeOrder.htm?id=${itemDetailMap.portfolioItem.id}"/>">Execute Order  </a></td>
			</tr>
	 	</table>
	</div><!-- Ending DIV of Content Area !-->	
<%@ include file="/WEB-INF/jsp/footer.jsp" %>

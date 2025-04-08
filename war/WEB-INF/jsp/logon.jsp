<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<h2>Logon to Portfolio Administration</h2>
<article>
<center>


<br/>
    <h2> Please insert userName: webmedia and Password: webmedia </h2>
<form method="post">
     <table width="25%" border="1">
          <tr><td><td></tr>
          <tr>
               <td align="center" bgcolor="black">Log on</td>
          </tr>
          <tr>
               <td>
                    <table border="0" width="100%">
                         <tr>
                              <td width="33%" align="right">Username: </td>
                              <td width="66%" align="left">
                                   <spring:bind path="user.userName">
                                   <input type="text" name="userName" value="<c:out value="${status.value}"></c:out>"> </input>
                                   </spring:bind>
                                   
                              </td>
               
                         </tr>
                         <tr>
                              <td colspan="2" align="center">
                                   <spring:hasBindErrors name="user">
                                   <font color="red"><c:out value="${status.errorMessage}"/></font>
                                   </spring:hasBindErrors>
                              </td>
                         </tr>
                         <tr>
                              <td width="33%" align="right">Password: </td>
                              <td width="66%" align="left">
                                   <spring:bind path="user.password">
                                   <input type="password" name="password" />
                                   </spring:bind>
                              </td>
                         </tr>
                         <tr>
                              <td colspan="2" align="center">
                                   <spring:hasBindErrors name="user">
                                   <font color="red"><core:out value="${status.errorMessage}"/></font>
                                   </spring:hasBindErrors>
                              </td>
                         </tr>
                         <tr>
                              <td align="center" colspan="2">
                              <a href="<c:url value="portfolio.htm"/>">Login</a>
                                   <input type="submit" alignment="center" value="Logon">
                              </td>
                         </tr>
                    </table>
                         
               </td>
          </tr>
     </table>
          
</form>

</center>
</article>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>

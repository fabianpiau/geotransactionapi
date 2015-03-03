<!DOCTYPE html>
<html lang="en">
<body>

<form action="/map/aggregate" method="post">

    <input type="submit" value="Filter"/>
</form>

<table>
<#list regionTransactionStats as regionTransactionStat>
    <tr>
        <td>${regionTransactionStat.region}</td>
        <td>${regionTransactionStat.nbTransactions}</td>
        <td>${regionTransactionStat.totalAmount}</td>
    </tr>
</#list>
</table>


</body>
</html>
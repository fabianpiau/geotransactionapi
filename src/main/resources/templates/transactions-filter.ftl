<!DOCTYPE html>
<html lang="en">
<body>

<form action="/transactions/filter" method="post">
    <select id="region" name="region">
    <#list locations as location>
        <option value="${location.region}">${location.region}</option>
    </#list>
    </select>
    <input type="submit" value="Filter"/>
</form>

<table>
<#list transactions as transaction>
    <tr>
        <td>${transaction.location.postcode}</td>
        <td>${transaction.location.area}</td>
        <td>${transaction.location.region}</td>
        <td>${transaction.amount}</td>
        <td>${transaction.date?string('dd.MM.yyyy')}</td>
    </tr>
</#list>
</table>


</body>
</html>
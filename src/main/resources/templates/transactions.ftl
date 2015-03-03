<!DOCTYPE html>
<html lang="en">
<body>

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
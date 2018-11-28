###################################

RECEIPT

<#list order.items as item>
${item.name}: ${item.totalAmount?string["0.00"]}
</#list>

Sales taxes: ${order.salesTaxes?string["0.00"]}
Total: ${order.totalAmount?string["0.00"]}

###################################
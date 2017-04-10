<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>yonyou</title>
</head>
<body>
    personname ;  ${person.name}
    <br/>
　　<#list person.classMetas as p>
        id : ${p.id}
　　　　name : ${p.name}
　　　　age : ${p.age}
        <br/><br/>
　　</#list>
</body>
</html>
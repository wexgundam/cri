<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>

<head>
    <title>People</title>
</head>
<critc-css>
    <link rel="stylesheet"
          href="${staticServer}/assets/cropper3.0/cropper.min.css" />
    <link rel="stylesheet" href="${staticServer}/assets/cropper3.0/main.css" />
    <link href="${staticServer}/assets/metronic4.7/pages/css/profile.min.css" rel="stylesheet" type="text/css" />
    <link href="${staticServer }/assets/zTree3.5/css/zTreeStyle/metro.css" rel="stylesheet" type="text/css" />
</critc-css>
<body class="no-skin">

    <h1>${people.id}</h1>
    <h1>${people.name}</h1>
    <h1>${people.age}</h1>

</body>
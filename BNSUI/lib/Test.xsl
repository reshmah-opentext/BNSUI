<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <head>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                <script src="jquery.js"></script>
                <script>
                    $( document ).ready(function() {
                    var fail = $("tr.fail");
                    fail.each(function() {
                    $(this).prevAll('tr.section').eq(0).css({ "background-color": "red" });
                    });

                    //collapse and expand sections
                    $('#tableMain').on('click', 'tr.section',function(){
                    $(this).nextUntil('tr.section').slideToggle(200);
                    });
                    });
                </script>
                <style>
                    table.gridtable tr.section~tr.datarow{
                    display: none;
                    }
                    table.gridtable tr.section{
                    background-color: #008000
                    }
                    table.gridtable tr.section:hover {
                    cursor: pointer;
                    }
                    html, body,table{
                    width:100%;
                    padding:0;
                    margin:0;
                    }

                    table {
                    table-layout:auto;
                    }

                    td.wrap{
                    max-width:200px;
                    overflow: hidden;
                    text-overflow: ellipsis;
                    word-wrap: break-word;
                    }
                </style>
            </head>
            <body>
                <div class="container" id="container">
                    <h1 align='center'>Test Results</h1>
                    <table border="1" class="gridtable" id="tableMain">
                        <thead>
                            <tr class="tableheader">
                                <th>Step</th>
                                <th>Description</th>
                                <th>Actual</th>
                                <th>Expected</th>
                                <th>Status</th>
                                <th>Time</th>
                                <th>ScreenShot</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="Tests/TestResults">
                                <xsl:choose>
                                    <xsl:when test="Step='Section'">
                                        <tr title="Expand / Collapse" class="section">
                                            <td align='center' width='10%'>
                                                <b>
                                                    <font face="Palatino Linotype" color="white">
                                                        <xsl:value-of select="Step" disable-output-escaping="yes"/>
                                                    </font>
                                                </b>
                                            </td>
                                            <td colspan="6" align='center' width='90%'>
                                                <b>
                                                    <font face="Palatino Linotype" color="white">
                                                        <xsl:value-of select="Description"
                                                                      disable-output-escaping="yes"/>
                                                    </font>
                                                </b>
                                            </td>
                                        </tr>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <xsl:choose>
                                            <xsl:when test="Status='Pass'">
                                                <tr class="datarow">
                                                    <td class="wrap" align="center" width="10%">
                                                        <xsl:value-of select="Step" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Description"
                                                                      disable-output-escaping="yes"></xsl:value-of>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Actual" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Expected" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td align="center" width="10%" BGCOLOR="#00ff00">
                                                        <b>
                                                            <xsl:value-of select="Status"/>
                                                        </b>
                                                    </td>
                                                    <td align="center" width="10%">
                                                        <xsl:value-of select="Time"/>
                                                    </td>
                                                    <xsl:if test="ScreenShot!=' '">
                                                        <td align='center' width='10%'>
                                                            <a href="./ScreenShots/{ScreenShot}">Screen Shot
                                                            </a>
                                                        </td>
                                                    </xsl:if>

                                                    <xsl:if test="ScreenShot=' '">
                                                        <td align='center' width='10%'>
                                                        </td>
                                                    </xsl:if>
                                                </tr>
                                            </xsl:when>
                                            <xsl:when test="Status='Fail'">
                                                <tr class="datarow fail">
                                                    <td class="wrap" align="center" width="10%">
                                                        <font color="red">
                                                            <xsl:value-of select="Step" disable-output-escaping="yes"/>
                                                        </font>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <font color="red">
                                                            <xsl:value-of select="Description"
                                                                          disable-output-escaping="yes"></xsl:value-of>
                                                        </font>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <font color="red">
                                                            <xsl:value-of select="Actual"
                                                                          disable-output-escaping="yes"/>
                                                        </font>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <font color="red">
                                                            <xsl:value-of select="Expected"
                                                                          disable-output-escaping="yes"/>
                                                        </font>
                                                    </td>
                                                    <td align="center" width="10%" BGCOLOR="#FF0000">
                                                        <b>
                                                            <xsl:value-of select="Status"/>
                                                        </b>
                                                    </td>
                                                    <td align="center" width="10%">
                                                        <font color="red">
                                                            <xsl:value-of select="Time"/>
                                                        </font>
                                                    </td>
                                                    <xsl:if test="ScreenShot!=' '">
                                                        <td align='center' width='10%'>
                                                            <font color="red">
                                                                <a href="./ScreenShots/{ScreenShot}">Screen Shot
                                                                </a>
                                                            </font>
                                                        </td>
                                                    </xsl:if>

                                                    <xsl:if test="ScreenShot=' '">
                                                        <td align='center' width='10%'>
                                                        </td>
                                                    </xsl:if>
                                                </tr>
                                            </xsl:when>
                                            <xsl:when test="Status='Warning'">
                                                <tr class="datarow">
                                                    <td class="wrap" align="center" width="10%">
                                                        <xsl:value-of select="Step" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Description"
                                                                      disable-output-escaping="yes"></xsl:value-of>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Actual" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Expected" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td align="center" width="10%" BGCOLOR="#FFFF00">
                                                        <b>
                                                            <xsl:value-of select="Status"/>
                                                        </b>
                                                    </td>
                                                    <td align="center" width="10%">
                                                        <xsl:value-of select="Time"/>
                                                    </td>
                                                    <xsl:if test="ScreenShot!=' '">
                                                        <td align='center' width='10%'>
                                                            <a href="./ScreenShots/{ScreenShot}">Screen Shot
                                                            </a>
                                                        </td>
                                                    </xsl:if>

                                                    <xsl:if test="ScreenShot=' '">
                                                        <td align='center' width='10%'>
                                                        </td>
                                                    </xsl:if>
                                                </tr>
                                            </xsl:when>
                                            <xsl:when test="Status='SKIPPED'">
                                                <tr class="datarow">
                                                    <td class="wrap" align="center" width="10%">
                                                        <xsl:value-of select="Step" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Description"
                                                                      disable-output-escaping="yes"></xsl:value-of>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Actual" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Expected" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td align="center" width="10%" BGCOLOR="#A9A9A9">
                                                        <b>
                                                            <xsl:value-of select="Status"/>
                                                        </b>
                                                    </td>
                                                    <td align="center" width="10%">
                                                        <xsl:value-of select="Time"/>
                                                    </td>
                                                    <xsl:if test="ScreenShot!=' '">
                                                        <td align='center' width='10%'>
                                                            <a href="./ScreenShots/{ScreenShot}">Screen Shot
                                                            </a>
                                                        </td>
                                                    </xsl:if>

                                                    <xsl:if test="ScreenShot=' '">
                                                        <td align='center' width='10%'>
                                                        </td>
                                                    </xsl:if>
                                                </tr>
                                            </xsl:when>
                                            <xsl:when test="Status='Done'">

                                                <tr class="datarow">
                                                    <td class="wrap" align="center" width="10%">
                                                        <xsl:value-of select="Step" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Description"
                                                                      disable-output-escaping="yes"></xsl:value-of>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Actual" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td class="wrap" align="center" width="20%">
                                                        <xsl:value-of select="Expected" disable-output-escaping="yes"/>
                                                    </td>
                                                    <td align="center" width="10%">
                                                        <b>
                                                            <xsl:value-of select="Status"/>
                                                        </b>
                                                    </td>
                                                    <td align="center" width="10%">
                                                        <xsl:value-of select="Time"/>
                                                    </td>
                                                    <xsl:if test="ScreenShot!=' '">
                                                        <td align='center' width='10%'>
                                                            <a href="./ScreenShots/{ScreenShot}">Screen Shot
                                                            </a>
                                                        </td>
                                                    </xsl:if>

                                                    <xsl:if test="ScreenShot=' '">
                                                        <td align='center' width='10%'>
                                                        </td>
                                                    </xsl:if>
                                                </tr>
                                            </xsl:when>
                                        </xsl:choose>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

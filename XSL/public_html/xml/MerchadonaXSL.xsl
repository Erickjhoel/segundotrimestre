<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : newstylesheet.xsl
    Created on : 21 de marzo de 2018, 10:39
    Author     : daw
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/Merchadona">
        <html>
            <head>
                <title>Merchadona</title>
                <link href="../ccs/ccsmerchadona.css" rel="stylesheet" type="text/css"/>
            </head>
            <body>
                <h2>MERCHADONA</h2>
                <div class="grande">
                    <div>
                        <table class="tablaCajero">
                            <tr style="background:#fe9a53" >
                                <td>CAJERO</td>
                            </tr>
                            <xsl:for-each select="Empleados/Cajero">
                                <tr class="primero">
                                    <td>
                                        Nombre:
                                        <xsl:value-of select="Nombre"/>
                                    </td>
                                </tr>
                                <tr class="primero">
                                    <td>
                                        ID:
                                        <xsl:value-of select="ID"/>
                                    </td>
                                </tr>
                                <tr class="primero">
                                    <xsl:choose>
                                        <xsl:when test="NumeroProductosVendidos > 5" >
                                            <td style="background:green" >
                                                Numero de productos vendidos:
                                                <xsl:value-of select="NumeroProductosVendidos"/>
                                            </td>
                                        </xsl:when>
                                        <xsl:otherwise >
                                            <td style="background:red" >
                                                Numero de productos vendidos:
                                                <xsl:value-of select="NumeroProductosVendidos"/>
                                            </td>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </tr>
                            </xsl:for-each>
                        </table> 
                    </div>
                    <div>
                        <table class="tablaReponedor">
                            <tr  style="background:#fe9a53" >
                                <td>REPONEDOR</td>
                            </tr>
                            <xsl:for-each select="Empleados/Reponedor">
                                <tr class="primero">
                                    <td>
                                        Nombre:
                                        <xsl:value-of select="Nombre"/>
                                    </td>
                                </tr>
                                <tr class="primero">
                                    <td>
                                        ID:
                                        <xsl:value-of select="ID"/>
                                    </td>
                                </tr>
                                <tr class="primero">
                                    <xsl:choose>
                                        <xsl:when test="NumeroProductosRepuestos > 5" >
                                            <td style="background:green" >
                                                Numero de productos repuestos:
                                                <xsl:value-of select="NumeroProductosRepuestos"/>
                                            </td>
                                        </xsl:when>
                                        <xsl:otherwise >
                                            <td style="background:red" >
                                                Numero de productos repuestos:
                                                <xsl:value-of select="NumeroProductosRepuestos"/>
                                            </td>
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </tr>
                            </xsl:for-each>
                        </table> 
                    </div>
                </div>    
                <div class="grande2">
                    <div>
                        <table class="tablaPerecedero">
                            <tr  style="background:#fe9a53" >
                                <td>PERECEDERO</td>
                            </tr>
                            <xsl:for-each select="Productos/Perecedero">
                                <tr class="primero">
                                    <td>
                                        Fecha:
                                        <xsl:value-of select="FechaDeReposicion"/>
                                    </td>
                                </tr>
                                <tr class="primero">
                                    <td>
                                        Precio:
                                        <xsl:value-of select="PrecioProducto"/>
                                    </td>
                                </tr>
                                <tr class="primero">
                                    
                                    <td>
                                        Nombre:
                                        <xsl:value-of select="NombreProducto"/>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </table> 
                    </div>
                    <div>
                        <table class="tablaNoPerecedero">
                            <tr  style="background:#fe9a53" >
                                <td>No PERECEDERO</td>
                            </tr>
                            <xsl:for-each select="Productos/NoPerecedero">
                                
                                <tr class="primero">
                                    <td>
                                        Precio:
                                        <xsl:value-of select="PrecioProducto"/>
                                    </td>
                                </tr>
                                <tr class="primero">
                                    <td>
                                        Nombre:
                                        <xsl:value-of select="NombreProducto"/>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </table> 
                    </div>
                    
                </div>    
                
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>

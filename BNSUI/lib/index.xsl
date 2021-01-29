<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="/">
		<html>
			<body>
				<!-- Title report -->
				<CENTER>
					<H1>
						<FONT COLOR="#0066CC">
							<U>
								<FONT FACE="Times New Roman">
									<xsl:value-of select="//Report/ReportName"/>
								</FONT>
							</U>
						</FONT>
					</H1>
				</CENTER>
				<!-- Top Panel Table  -->

				<CENTER>
					<table border="0" align='center' width="70%">
						<tr>
							<td width="50%">
								<!-- Table on left side -->
								<table border="1" align='center' width="100%">
									<tr>
										<th width="45%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">Test
											Type
										</th>
										<td align="center">
											<xsl:value-of select="//Report/TestType"/>
										</td>
									</tr>
									<tr>
										<th width="45%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">Start
											Time
										</th>
										<td align="center">
											<xsl:value-of select="//Report/TestStartedTime"/>
										</td>
									</tr>
									<tr>
										<th width="45%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">End
											Time
										</th>
										<td align="center">
											<xsl:value-of select="//Report/TestEndedTime"/>
										</td>
									</tr>
									<tr>
										<th width="45%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">Total
											Execution(Mins)
										</th>
										<td align="center">
											<xsl:value-of select="//Report/TotalExecution"/>
										</td>
									</tr>
									<tr>
										<th width="45%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">Total
											Scripts:Passed:Failed: Skipped
										</th>
										<td align="center">
											<xsl:value-of select="//Report/ExecutionStatistics"/>
										</td>
									</tr>
								</table>
								<!-- END -->
							</td>

							<td width="50%">
								<!-- Table on left side -->
								<table border="1" align='center' width="100%">
									<tr>
										<th width="25%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">Host
											Name
										</th>
										<td align="center">
											<xsl:value-of select="//Report/HostName"/>
										</td>
									</tr>
									<tr>
										<th width="25%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">
											Operating System
										</th>
										<td align="center">
											<xsl:value-of select="//Report/OS"/>
										</td>
									</tr>
									<tr>
										<th width="25%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">Browser
											Type/
											Version/ Resolution~
										</th>
										<td align="center">
											<xsl:value-of select="//Report/BrowserDetails"/>
										</td>
									</tr>
									<tr>
										<th width="25%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">Time
											Zone
										</th>
										<td align="center">
											<xsl:value-of select="//Report/TimeZone" disable-output-escaping="yes"/>
										</td>
									</tr>
								</table>
								<!-- END -->
							</td>

						</tr>
					</table>
					<BR/>
				</CENTER>

				<CENTER>
					<table border="1" align='center' width="70%">
						<tr ALIGN="CENTER">

							<Th width="5%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">
								<b>
									<u>Sl.No</u>
								</b>
							</Th>
							<Th width="55%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">
								<b>
									<u>Script Name</u>
								</b>
							</Th>
							<Th width="10%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">
								<b>
									<u>Duration(Min)</u>
								</b>
							</Th>
							<Th width="10%" Style="color:#FFFFFF;font-weight:bold" BGCOLOR="#0066CC">
								<b>
									<u>Status</u>
								</b>
							</Th>
						</tr>

						<xsl:for-each select="Tests/Step">

							<xsl:if test="Status='PASS'">
								<tr>
									<td align='center'>
										<xsl:value-of select="NO"/>
									</td>
									<td align='center'>
										<xsl:if test="URL!=' '">
											<a href="{URL}{StepName}.html">
												<xsl:value-of select="StepName"/>
											</a>
										</xsl:if>
										<xsl:if test="URL=' '">
											<a href="{StepName}.html">
												<xsl:value-of select="StepName"/>
											</a>
										</xsl:if>
									</td>
									<td align='center'>
										<xsl:value-of select="Duration"/>
									</td>
									<td align='center' BGCOLOR="#00ff00">
										<FONT>
											<b>
												<xsl:value-of select="Status"/>
											</b>
										</FONT>
									</td>
								</tr>
							</xsl:if>

							<xsl:if test="Status='WARNING'">
								<tr>
									<td align='center'>
										<xsl:value-of select="NO"/>
									</td>
									<td align='center'>
										<xsl:if test="URL!=' '">
											<a href="{URL}{StepName}.html">
												<xsl:value-of select="StepName"/>
											</a>
										</xsl:if>
										<xsl:if test="URL=' '">
											<a href="{StepName}.html">
												<xsl:value-of select="StepName"/>
											</a>
										</xsl:if>
									</td>
									<td align='center'>
										<xsl:value-of select="Duration"/>
									</td>
									<td align='center' BGCOLOR="#ffff00">
										<FONT>
											<b>
												<xsl:value-of select="Status"/>
											</b>
										</FONT>
									</td>
								</tr>
							</xsl:if>

							<xsl:if test="Status='SKIPPED'">
								<tr>
									<td align='center'>
										<xsl:value-of select="NO"/>
									</td>
									<td align='center'>
										<xsl:if test="URL!=' '">
											<a href="{URL}{StepName}.html">
												<xsl:value-of select="StepName"/>
											</a>
										</xsl:if>
										<xsl:if test="URL=' '">
											<a href="{StepName}.html">
												<xsl:value-of select="StepName"/>
											</a>
										</xsl:if>
									</td>
									<td align='center'>
										<xsl:value-of select="Duration"/>
									</td>
									<td align='center' BGCOLOR="#A9A9A9">
										<FONT>
											<b>
												<xsl:value-of select="Status"/>
											</b>
										</FONT>
									</td>
								</tr>
							</xsl:if>

							<xsl:if test="Status='FAIL'">
								<tr>
									<td align='center'>
										<xsl:value-of select="NO"/>
									</td>
									<td align='center'>
										<xsl:if test="URL!=' '">
											<a href="{URL}{StepName}.html">
												<xsl:value-of select="StepName"/>
											</a>
										</xsl:if>
										<xsl:if test="URL=' '">
											<a href="{StepName}.html">
												<xsl:value-of select="StepName"/>
											</a>
										</xsl:if>
									</td>
									<td align='center'>
										<xsl:value-of select="Duration"/>
									</td>
									<td align='center' BGCOLOR="#FF0000">
										<FONT>
											<b>
												<xsl:value-of select="Status"/>
											</b>
										</FONT>
									</td>
								</tr>
							</xsl:if>

						</xsl:for-each>
					</table>
				</CENTER>

			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
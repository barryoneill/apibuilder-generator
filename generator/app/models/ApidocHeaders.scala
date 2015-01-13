package models

import lib.Constants

case class ApidocHeaders(userAgent: Option[String]) {

  def toJavaString(): String = {
    "/**\n" +
    elements.map(s => s" * $s").mkString("\n") + "\n" +
    " */"
  }

  def toRubyString(): String = elements.map(s => s"# $s").mkString("\n")

  private val elements = Seq(
    Some(s"Generated by apidoc - ${Constants.ApidocUrl}"),
    userAgent
  ).flatten

}
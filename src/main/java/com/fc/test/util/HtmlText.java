package com.fc.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author xumingming
 * @Date 2020-06-16 13:36
 */
public class HtmlText {
    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式 

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); //过滤script标签 

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); //过滤style标签 

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); //过滤html标签 
        return htmlStr.trim(); //返回文本字符串 
    }

    public static void main(String[] args) {
        String name = "本的网站，可以使用转向带参数，请求无脚本时候的网站内容。</li>" +
                "<li>页面标题是页面必不可少的，同时也是蜘蛛索引的重要指标，可以考虑程序动态输出。</li>" +
                "<li>引入主要的样式文件，同时根据设备类型来引入设备相关的样式文件，以支持平板以及打印机。</li>" +
                "<li>前端脚本通过后端变量设置版本，以利于文档和静态资源的更新。</li>" +
                "<li>关于前置全局脚本，需要做到：huanhuanhuanhuanhuanhuan<ul>" +
                "<li>如果页面不作为iframe内容使用，要防止恶意被嵌套，发生误导或者钓鱼相关的事情。huanhuanhuanhuanhuanhuan<ul>" +
                "<li>如果使用类名作为钩子来告知页面程序是否支持调用，可以在此进一步处理。</li>" +
                "<li>对于旧版本的IE，这里特指版本小于等于IE8的老旧浏览器，如果要做优雅降级，那么需要再此做前置程序处理。</li>" +
                "<li>如果页面程序存在依赖数据来渲染的情况，前置的数据也推荐放置于此。</li><li>如果页面依赖脚本加载器，可以在此添加加载器脚本。</li>" +
                "<li>对于旧版本的浏览器可以使用IE条件注释配合shim脚本，以及respond来提供一些额外的功能支持，以减少写代码时的额外处理，以及保持一致性访问。</li>" +
                "<li>页面关键词和相关说明也是至关重要的，如果你做SEO的话。</li>" +
                "<li>如果你还要提供RSS以及PING,请也在此一并提供。</li>" +
                "<li>对于搜索引擎提供shortlink，以合并改版rewrite后的状况。</li></ul></li></ul></li></ul>" +
                "<p>–EOF–</p></div></div>";
        System.out.println(delHTMLTag(name));
    }
}
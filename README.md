AntDemo
=======

ant auto build Android Package

Android ant 自动打包脚本：自动替换友盟渠道、版本号、包名


打包时自动更换友盟渠道
----------------------

    ant auto-release -DUMENG_CHANNEL=googlePlayStore

即会把AndroidManifest.xml中的友盟渠道替换成googlePlayStore，然后打包

    ant auto-release -DUMENG_CHANNEL=xiaomiAppStore

即会打出小米应用商店的包


打包时自动更换包名
------------------

    ant auto-release -Dpackage=com.example.ant.beta

把包名自动改成com.example.ant.beta，然后打包


打包时使用时间作为版本号
------------------

    ant auto-debug -Dversion=time

把版本号改成时间，然后打包，效果：

versionCode是时间戳，比如1390969254

versionName是日期，比如14.1.29.1220


多个参数任意组合
------------

    ant auto-release -DUMENG_CHANNEL=googlePlayStore -Dpackage=com.example.ant.beta -Dversion=time

即打出google play的beta包，使用时间作为版本号


debug与release签名
------------------

    ant auto-debug

使用debug签名（路径~/.android/debug.keystore），请参考http://developer.android.com/tools/publishing/app-signing.html#debugmode

    ant auto-release

使用release签名，请修改ant.properties中的路径、密码等等，参考http://developer.android.com/tools/building/building-cmdline.html#ReleaseMode


如何集成到我的项目里
--------------------

前提：了解android官方文档，在项目目录中执行官方命令能打包，比如常见的打包步骤：

    android update project -p . -s -t "android-19"
    ant debug

如果是用Linux系统，则不用记上面这么长的命令，下载`Makefile`，放到项目目录中，然后执行：

    make
    ant debug

如果ant debug打包能通过，则可以使用下面的自动打包。

下载`custom_rules.xml`，放到项目目录中，然后执行：

    ant auto-debug -Dversion=time

即可，生成的包在`./bin/`中。

如果想打release包，下载`ant.properties`，修改其中的密码等配置，然后执行：

    ant auto-release -DUMENG_CHANNEL=googlePlayStore -Dpackage=com.example.ant.beta

即可。

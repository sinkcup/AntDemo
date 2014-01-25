AntDemo
=======

ant auto build Android Package


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


多个参数任意组合
------------

    ant auto-release -DUMENG_CHANNEL=googlePlayStore -Dpackage=com.example.ant.beta
即打出google play的beta包


debug与release签名
------------------

    ant auto-debug
使用debug签名（路径~/.android/debug.keystore），请参考http://developer.android.com/tools/publishing/app-signing.html#debugmode
    ant auto-release
使用release签名，请修改ant.properties中的路径、密码等等，参考http://developer.android.com/tools/building/building-cmdline.html#ReleaseMode

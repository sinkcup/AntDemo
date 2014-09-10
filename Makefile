target = $(shell egrep -m 1 "^target=" project.properties | sed -n -e 's/^target=\(.*\)/\1/p')

#安装配置本地开发环境
install:
	@/bin/cp ./git-pre-commit .git/hooks/pre-commit
	@android update project -p . -s -t "$(target)"
review:
	@checkstyle -c checkstyle/android_checks.xml -r src

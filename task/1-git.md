## 本文学习基础git使用

前言：阅读本文之前请先学习git最基础教程，如<https://www.liaoxuefeng.com/wiki/896043488029600>

1.安装git以及配置git全局信息

2.`git clone xxx`

xxx为代码库，本项目为git@github.com:euphonium1998/eupho-study.git

3.`git checkout -b xxx`

`git clone`的代码默认在main分支上，各位需要创建一个新的分支xxx，这就是未来你写代码的分支，未来所有操作都将在xxx分支上进行。xxx自行命名，可以为你的名字或昵称。

4.进行代码开发。

在本次学习中请各位对src/1/main.md文件下代码进行修改。在最下行随便写点东西。

5.`git pull <远程主机名> <远程分支名>:<本地分支名>`

将远程分支（一般为main分支）拉取到本地，在未来的开发过程中存在协同开发的情况。当你完成自己部分开发，要推到远程仓库合并到main分支前，一定要检查当前main分支是否存在修改，防止远程合并冲突。远程主机名为`origin`，这是在`git clone`的过程中程序设置的。

6.`git add .`

提交当前目录下的所有修改代码到暂存区（最好先git diff检查一下修改的部分）

7.`git commit -m "xxx"`

本地仓库提交，xxx为对本次提交所做的描述

8.`git push <远程主机名> <本地分支名>:<远程分支名>`

将本地分支推到远程仓库对应分支，远程分支与本地分支名应该尽量相同，远程主机名也默认为`origin`

如果推不上来，切记不要`git push -f`。谁这么做就请吃海底捞/doge。

9.进入github对应仓库页面，提交pull request。将自己的分支与main分支进行合并。按照下方图片顺序。如果之前操作正常就不会出现冲突，如果出现冲突就比较麻烦了

![step 1](/img/step1.png)
![step 2](/img/step2.png)
![step 3](/img/step3.png)

ps: 这就是最基本的分支开发流程，存在冲突也不用慌。最基本的方式就是再本地仓库手动解决冲突。或者重新clone一份代码进行编辑。希望大家可以避免产生分支冲突。




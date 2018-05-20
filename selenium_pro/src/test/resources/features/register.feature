Feature: ECshop 用户注册特性测试

	Scenario: 成功注册一个用户
		Given 打开首页"http://localhost/ecshop"
		And 点击免费注册按钮
		When 填写用户名"liudao003"
		And 填写邮箱"liudao003@163.com"
		And 填写密码"123456"
		And 填写确认密码"123456"
		And 填写手机号"123456"
		And 点击注册按钮
		Then 页面跳转显示"用户名 liudao003 注册成功"
		And 关闭浏览器
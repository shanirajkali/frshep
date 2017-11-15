<style type="text/css">
	.newspost{
			font-size: 25px;
			overflow: hidden;
			border-radius: 6px;
		}
</style>
<div id="newsPost_div" class="text-primary" ng-controller="newsPostController">

	<div>
		<select id="super_tag" class="" type="text" name="super_tag"></select>
		<select id="sub_tag_0" type="text" name="sub_tag_0"></select>
		<select id="sub_tag_1" type="text" name="sub_tag_1"></select>
		<select id="sub_tag_2" type="text" name="sub_tag_2"></select>
		<select id="sub_tag_3" type="text" name="sub_tag_2"></select>
		<button>Add Tag</button>
	</div>

	<div><textarea class="newspost" rows="3" minlength="60" maxlength="95"></textarea></div>

	<div><textarea class="newspost" rows="3" minlength="60" maxlength="95"></textarea>
	</div>

	<button >POST</button>
</div>
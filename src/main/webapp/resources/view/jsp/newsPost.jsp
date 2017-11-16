<style type="text/css">
	.newspost{
			font-size: 25px;
			overflow: hidden;
			border-radius: 6px;
		}
</style>
<div id="newsPost_div" class="container" ng-controller="newsPostController">

	<div id="tag_div" class="row">
		<div class="col-lg-2">	<select id="tag_super" style="display:none" id="super_tag" class="form-control" type="text" name="super_tag" ng-model="tagModel.tagSuper" ng-options="obj as obj for obj in tagModel.tagSuperValues"></select></div>
		<div class="col-lg-2"> <select id="tag_sub0" style="display:none"  id="tag_sub0" class="form-control" type="text" name="sub_tag_0" ng-model="tagModel.tagSub0" ng-options="obj as obj for obj in tagModel.tagSub0Values"></select></div>
		<div class="col-lg-2"> <select id="tag_sub1" style="display:none" id="tag_sub1" class="form-control"  type="text" name="sub_tag_1" ng-model="tagModel.tagSub1" ng-options="obj as obj for obj in tagModel.tagSub1Values"></select></div>
		<div class="col-lg-2"> <select id="tag_sub2" style="display:none" id="tag_sub2" class="form-control"  type="text" name="sub_tag_2" ng-model="tagModel.tagSub2" ng-options="obj as obj for obj in tagModel.tagSub2Values"></select></div>
		<div class="col-lg-2"> <select id="tag_sub3" style="display:none" id="tag_sub3" class="form-control"  type="text" name="sub_tag_3" ng-model="tagModel.tagSub3" ng-options="obj as obj for obj in tagModel.tagSub3Values"></select></div>
		<div class="col-lg-2"> <button ng-click="fun()" class="form-control">add tag</button></div>
	</div>

	<div class="row"><div class="col-lg-8"><textarea class="form-control" rows="3" minlength="60" maxlength="95"></textarea></div></div>

	<div class="row"><div class="col-lg-8"><textarea class="form-control" rows="3" minlength="60" maxlength="95"></textarea></div>
	</div>

	<button class="form-control" ng-click="getTag.allSuperTag()">POST</button>
</div>


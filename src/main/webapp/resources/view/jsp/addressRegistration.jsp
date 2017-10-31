<div id="address" ng-controller="AddressController" >

	<div id="getAddress">
		<select class="form-control" id="pinList"  ng-model="address.pin" ng-model="address.pin" ng-init=""></select>
		<select class="form-control" id="stateList" ng-model="address.state" ng-init="setStateToSelect()" ng-change="setDistrictToSelect()">
		</select>
		<select class="form-control" id="districtList" ng-model="address.district" ng-change="setTahsilToSelect()" ></select>
		<select class="form-control" id="tahsilList" ng-model="address.tahsil"  ng-change="setLocaleToSelect()"></select>
		<select class="form-control" id="localeList" ng-model="address.locale"></select>
	</div>
	
	<button class="form-control" id="addNewAddressButton" ng-click="showAddAddressPanel()" ng-init="">Add Address</button> 
	
	<div id="addAddressPanel" ng-init="hideAddAddressPanel()">
		State: <input class="form-control" type="text" ng-model="address.state"><br>
    	District : <input class="form-control" type="text" ng-model="address.district"><br>
    	Tahsil : <input class="form-control" type="text" ng-model="address.tahsil"><br>
    	Locale : <input class="form-control" type="text" ng-model="address.locale"><br>
    	PIN:	<input class="form-control" type="number" ng-model="address.pin"><br>
    	<button class="form-control" ng-click="addressSubmit()">Submit</button>
	</div>
	<div ></div>
</div>
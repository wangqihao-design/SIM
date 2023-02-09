<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="矿井名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="矿井名称"></el-input>
    </el-form-item>
    <el-form-item label="产出物品1" prop="productid1">
      <el-input v-model="dataForm.productid1" placeholder="产出物品1"></el-input>
    </el-form-item>
    <el-form-item label="产出物品2" prop="productid2">
      <el-input v-model="dataForm.productid2" placeholder="产出物品2"></el-input>
    </el-form-item>
    <el-form-item label="产出物品3【最多产出3种，不够再改】" prop="productid3">
      <el-input v-model="dataForm.productid3" placeholder="产出物品3【最多产出3种，不够再改】"></el-input>
    </el-form-item>
    <el-form-item label="矿井价格" prop="cost">
      <el-input v-model="dataForm.cost" placeholder="矿井价格"></el-input>
    </el-form-item>
    <el-form-item label="矿井位置" prop="location">
      <el-input v-model="dataForm.location" placeholder="矿井位置"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          name: '',
          productid1: '',
          productid2: '',
          productid3: '',
          cost: '',
          location: ''
        },
        dataRule: {
          name: [
            { required: true, message: '矿井名称不能为空', trigger: 'blur' }
          ],
          productid1: [
            { required: true, message: '产出物品1不能为空', trigger: 'blur' }
          ],
          productid2: [
            { required: true, message: '产出物品2不能为空', trigger: 'blur' }
          ],
          productid3: [
            { required: true, message: '产出物品3【最多产出3种，不够再改】不能为空', trigger: 'blur' }
          ],
          cost: [
            { required: true, message: '矿井价格不能为空', trigger: 'blur' }
          ],
          location: [
            { required: true, message: '矿井位置不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/mine/mmsmine/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.mmsMine.name
                this.dataForm.productid1 = data.mmsMine.productid1
                this.dataForm.productid2 = data.mmsMine.productid2
                this.dataForm.productid3 = data.mmsMine.productid3
                this.dataForm.cost = data.mmsMine.cost
                this.dataForm.location = data.mmsMine.location
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/mine/mmsmine/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'productid1': this.dataForm.productid1,
                'productid2': this.dataForm.productid2,
                'productid3': this.dataForm.productid3,
                'cost': this.dataForm.cost,
                'location': this.dataForm.location
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>

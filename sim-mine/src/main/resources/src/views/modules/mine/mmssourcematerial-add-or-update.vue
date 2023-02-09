<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="原料名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="原料名称"></el-input>
    </el-form-item>
    <el-form-item label="原料品质【0-错误 1-顶级 2-高级 3-中级 4-低级 5-差】" prop="quality">
      <el-input v-model="dataForm.quality" placeholder="原料品质【0-错误 1-顶级 2-高级 3-中级 4-低级 5-差】"></el-input>
    </el-form-item>
    <el-form-item label="生产需要的时间(s)" prop="produceTime">
      <el-input v-model="dataForm.produceTime" placeholder="生产需要的时间(s)"></el-input>
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
          quality: '',
          produceTime: ''
        },
        dataRule: {
          name: [
            { required: true, message: '原料名称不能为空', trigger: 'blur' }
          ],
          quality: [
            { required: true, message: '原料品质【0-错误 1-顶级 2-高级 3-中级 4-低级 5-差】不能为空', trigger: 'blur' }
          ],
          produceTime: [
            { required: true, message: '生产需要的时间(s)不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/mine/mmssourcematerial/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.mmsSourceMaterial.name
                this.dataForm.quality = data.mmsSourceMaterial.quality
                this.dataForm.produceTime = data.mmsSourceMaterial.produceTime
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
              url: this.$http.adornUrl(`/mine/mmssourcematerial/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'quality': this.dataForm.quality,
                'produceTime': this.dataForm.produceTime
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
